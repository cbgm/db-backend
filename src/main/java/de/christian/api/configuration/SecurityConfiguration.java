package de.christian.api.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private RestAuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	private RestLogoutSuccessHandler logoutSuccessHandler;

	@Autowired
	private DeniedHandler handler;
 
	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(passwordEncoder())
		.usersByUsernameQuery(
			"select username,password, enabled from user where username=?")
		.authoritiesByUsernameQuery(
			"select username, role from user_roles where username=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		RequestMatcher csrfRequestMatcher = new RequestMatcher() {

			private RegexRequestMatcher requestMatcher =
					new RegexRequestMatcher("/admin", null);

			public boolean matches(HttpServletRequest request) {

				// Enable the CSRF
				if(requestMatcher.matches(request))
					return true;

				return false;
			}

		};

		http.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class);
		http
			.csrf()
				.requireCsrfProtectionMatcher(csrfRequestMatcher)
				.and()
			.authorizeRequests()
				.antMatchers("/**/**")
				.permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.successHandler(authenticationSuccessHandler)
				.and()
			.logout()
				.logoutSuccessHandler(logoutSuccessHandler)
				.permitAll();
		http.addFilterAfter(new CsrfTokenResponseHeaderBindingFilter(), CsrfFilter.class);
	}


	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}