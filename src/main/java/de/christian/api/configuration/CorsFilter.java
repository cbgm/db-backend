//package de.christian.api.configuration;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.util.StringUtils;
// 
// 
//public class CorsFilter implements Filter {
//	  private static final String ORIGIN = "Origin";
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
////        System.out.println("Filtering on...........................................................");
//        HttpServletResponse response = (HttpServletResponse) res;
//        HttpServletRequest request = (HttpServletRequest) req;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Vary", "Origin");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Headers", "Origin, X-CSRF-TOKEN, X-Requested-With, Accept, Content-Type");
//        chain.doFilter(req, res);
//
//	//  if (request.getMethod().equals("OPTIONS")) {
//	//      try {
//	//          response.getWriter().print("OK");
//	//          response.getWriter().flush();
//	//      } catch (IOException e) {
//	//      e.printStackTrace();
//	//      }
//	//  } else{
//	//      chain.doFilter(request, response);
//	//  }
//    }
//// 
//    public void init(FilterConfig filterConfig) {}
// 
//    public void destroy() {}
// 
//}

package de.christian.api.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
 
 
public class CorsFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		String origin = request.getHeader("Origin");

		response.addHeader("Access-Control-Allow-Origin", origin);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.addHeader("Access-Control-Max-Age", "10");
		response.addHeader("Access-Control-Expose-Headers", "X-CSRF-TOKEN");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");

		String reqHead = request.getHeader("Access-Control-Request-Headers");

		if (!StringUtils.isEmpty(reqHead)) {
			response.addHeader("Access-Control-Allow-Headers", reqHead);
		}

		if (request.getMethod().equals("OPTIONS")) {

			try {
				response.getWriter().print("OK");
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig filterConfig) {}
 
	public void destroy() {}
 
}