//package de.christian.api.dao.test;
//
//import java.util.Set;
//
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import de.christian.api.model.News;
//import de.christian.api.model.Project;
//import de.christian.api.model.User;
//import de.christian.api.service.interfaces.INewsService;
//import de.christian.api.service.interfaces.IProjectService;
//import de.christian.api.service.interfaces.IUserService;
//
//public class TestClean {
//
//	static ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		deleteProjects();
//		deleteNews();
//		deleteUsers();
//	}
//	
//	public static void deleteUsers(){
//		IUserService uservice = (IUserService) context.getBean("userService");
//		Set<User> users = uservice.getAllUsers();
//		for(User u : users){
//			uservice.delete(u);
//
//		}
//		
//	}
//	
//	public static void deleteProjects(){
//		IProjectService pservice = (IProjectService) context.getBean("projectService");
//		Set<Project> projects = pservice.getAllProjects();
//		for(Project p : projects){
//			pservice.delete(p);
//
//		}
//		
//	}
//	
//	public static void deleteNews(){
//		INewsService nservice = (INewsService) context.getBean("newsService");
//		Set<News> news = nservice.getAllNews();
//		for(News n : news){
//			nservice.delete(n);
//
//		}
//		
//	}
//}
