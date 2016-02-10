//package de.christian.api.dao.test;
//
//import java.util.Set;
//
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import de.christian.api.configuration.AppConfig;
//import de.christian.api.model.News;
//import de.christian.api.model.Project;
//import de.christian.api.model.User;
//import de.christian.api.service.interfaces.IProjectService;
//import de.christian.api.service.interfaces.IUserService;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
//        classes = { AppConfig.class, ServletConfig.class })
//@WebAppConfiguration
//public class UserTest {
//	
//	public static void main(String[] args) {
//		@SuppressWarnings("resource")
//		AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
//		context.scan("de.christian.api.configuration"); 
//		context.refresh();
//	    IUserService uservice = (IUserService) context.getBean("userService");
//		User u = new User("chris", "0815");
////		User u2 = new User("Alex", "0815");
//		uservice.save(u);
////		uservice.save(u2);
//		
//		Set<User> users = uservice.getAllUsers();
//		for(User user : users){
//			System.out.println(user.toString());
//		}
////		testWriteUser();
////		testWriteProject();
////		testDeleteUsers();
////		testDeleteUserWithNews();
////		testReadNews();
////		context.close();
//	}
//	
////	public static void testWriteUser(){
////		IUserService uservice = (IUserService) context.getBean("userService");
////		User u = new User("chris", "0815");
//////		User u2 = new User("Alex", "0815");
////		uservice.save(u);
//////		uservice.save(u2);
////		
////		Set<User> users = uservice.getAllUsers();
////		for(User user : users){
////			System.out.println(user.toString());
////		}
////		
////	}
////	
////	public static void testDeleteUserWithNews(){
////		IUserService uservice = (IUserService) context.getBean("userService");
////		Set<User> lusers = uservice.getAllUsers();
////		for(User u : lusers){
////			u.getNews().clear();
////			uservice.delete(u);
////		}
////	}
////	
////	public static void testDeleteUserWithoutProject(){
////		IUserService uservice = (IUserService) context.getBean("userService");
////		Set<User> lusers = uservice.getAllUsers();
////		for(User u : lusers){
////			u.getProjects().clear();
////			uservice.delete(u);
////			break;
////		}
////	}
////	
////	public static void testDeleteUserWithoutRelations(){
////		IUserService uservice = (IUserService) context.getBean("userService");
////		Set<User> lusers = uservice.getAllUsers();
////		for(User u : lusers){
////			u.getNews().clear();
////			uservice.delete(u);
////			break;
////		}
////	}
////	
////	public static void testWriteNews(){
////		IUserService uservice = (IUserService) context.getBean("userService");		
////		Set<User> users = uservice.getAllUsers();
////		for(User user : users){
////			
////			News news = new News("n1","neue news");
////			user.addNews(news);
////			uservice.update(user);
////			try {
////				Thread.sleep(500);
////			} catch (InterruptedException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////			Set<News> lnews= uservice.getUserNews(user);
////			for(News n : lnews)
////				System.out.println(n.toString());
////			break;
////		}
////		
////		
////	}
////	
////	public static void testReadNews(){
////		IUserService uservice = (IUserService) context.getBean("userService");		
////		Set<User> users = uservice.getAllUsers();
////		for(User user : users){
////			Set<News> lnews= uservice.getUserNews(user);
////			for(News n : lnews)
////				System.out.println(n.toString());
////			break;
////		}
////	}
////	
////	public static void testWriteProject(){
////		IUserService uservice = (IUserService) context.getBean("userService");		
////		Set<User> users = uservice.getAllUsers();
////		for(User user : users){
////			IProjectService pservice = (IProjectService) context.getBean("projectService"); 
////			Project project = new Project("p1","neue project");
////			pservice.save(project);
////			uservice.update(user);
////			try {
////				Thread.sleep(500);
////			} catch (InterruptedException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////			Set<Project> lproject= uservice.getUserProjects(user);
////			for(Project p : lproject)
////				System.out.println(p.toString());
////
////			break;
////		}
////		
////		
////	}
////	
////	//without deleting childs
////	public static void testDeleteUsers(){
////		IUserService uservice = (IUserService) context.getBean("userService");
////
////		
////		Set<User> users = uservice.getAllUsers();
////		for(User user : users){
//////			Set<Project> lprojects = uservice.getUserProjects(user);
//////			IProjectService pservice = (IProjectService) context.getBean("projectService"); 
//////			for(Project p : lprojects){
//////				p.setUser(null);
//////				pservice.save(p);
//////			}
//////			
//////			uservice = (IUserService) context.getBean("userService");
//////			uservice.delete(user);
////			uservice.delete(user);
////
////		}
////		
////	}
//
//}
