//package de.christian.api.dao.test;
//
//import java.util.Set;
//
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import de.christian.api.model.News;
//import de.christian.api.model.Tag;
//import de.christian.api.model.User;
//import de.christian.api.service.interfaces.INewsService;
//import de.christian.api.service.interfaces.ITagService;
//import de.christian.api.service.interfaces.IUserService;
//
//
//public class UserXNewsTest {
//
//	static ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		testWriteUser();
//		testWriteNews();
//		testAddTags();
//	}
//	
//	public static void testWriteUser(){
//		IUserService uservice = (IUserService) context.getBean("userService");
//		User u = new User("Chris", "0815");
//		User u2 = new User("Alex", "0815");
//		uservice.save(u);
//		uservice.save(u2);
//		
//		Set<User> users = uservice.getAllUsers();
//		for(User user : users){
//			System.out.println(user.toString());
//		}
//		
//	}
//	
//	public static void testWriteNews(){
//		IUserService uservice = (IUserService) context.getBean("userService");		
//		Set<User> users = uservice.getAllUsers();
//		for(User user : users){
//			News news = new News("n1","neue news");	
//			INewsService nservice = (INewsService) context.getBean("newsService"); 
//			nservice.save(news);
//			user.addNews(news);
//			
//			uservice.update(user);
//			
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Set<News> lnews= uservice.getUserNews(user);
//			for(News n : lnews)
//				System.out.println(n.toString());
//			break;
//		}
//		
//		
//	}
//	
//	public static void testAddTags(){
//		INewsService nservice = (INewsService) context.getBean("newsService"); 
//		Set<News> lnews = nservice.getAllNews();
//		for(News n : lnews){
//			ITagService tservice = (ITagService) context.getBean("tagService");		
//			Set<Tag> ltags = tservice.getAllTags();
//			nservice = (INewsService) context.getBean("newsService");
//			for(Tag t : ltags){
//				n.getTags().add(t);
//				
//			}
//			nservice.update(n);
//			
//			break;
//		}
//		
//		//read test
//		
//		
//		
//		
//	}
//	
//	
//	
//
//}
