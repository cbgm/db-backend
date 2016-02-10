//package de.christian.api.dao.test;
//
//import java.util.Set;
//
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import de.christian.api.model.Article;
//import de.christian.api.model.Project;
//import de.christian.api.model.Tag;
//import de.christian.api.model.User;
//import de.christian.api.service.interfaces.IProjectService;
//import de.christian.api.service.interfaces.ITagService;
//import de.christian.api.service.interfaces.IUserService;
//
//
//
//public class UserXProject {
//static ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		testWriteUser();
//		testWriteProject();
//		testAddArticle();
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
//	public static void testWriteProject(){
//		IUserService uservice = (IUserService) context.getBean("userService");		
//		Set<User> users = uservice.getAllUsers();
//		for(User user : users){
//			Project project = new Project("p1","neue Project");	
//			IProjectService pservice = (IProjectService) context.getBean("projectService"); 
//			pservice.save(project);
//			user.addProject(project);
//			
//			uservice.update(user);
//			
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Set<Project> lprojects = uservice.getUserProjects(user);
//			for(Project p : lprojects)
//				System.out.println(p.toString());
//			break;
//		}
//		
//		
//	}
//	
//	
//	
//	public static void testAddTags(){
//		IProjectService pservice = (IProjectService) context.getBean("projectService"); 
//		Set<Project> lprojects = pservice.getAllProjects();
//		for(Project p : lprojects){
//			ITagService tservice = (ITagService) context.getBean("tagService");		
//			Set<Tag> ltags = tservice.getAllTags();
//			pservice = (IProjectService) context.getBean("projectService");
//			for(Tag t : ltags){
//				p.getTags().add(t);
//				
//			}
//			pservice.update(p);
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
//	public static void testAddArticle(){
//		IProjectService pservice = (IProjectService) context.getBean("projectService"); 
//		Set<Project> lprojects = pservice.getAllProjects();
//		for(Project p : lprojects){
//			Article article = new Article("text");
//			//////////
//			
//			
//			///////////
//			article.setProject(p);
//			p.addArticle(article);
//			pservice.update(p);
//			
//			break;
//		}
//		
//		//read test
//		
//		
//	}
//	
//	public static void testAddTagsToArticle(){
//		IProjectService pservice = (IProjectService) context.getBean("projectService"); 
//		Set<Project> lprojects = pservice.getAllProjects();
//		for(Project p : lprojects){
//			Article article = new Article("text");
//			article.setProject(p);
//			p.addArticle(article);
//			pservice.update(p);
//			
//			break;
//		}
//		
//		//read test
//		
//		
//	}
//	
//	public static void testDeleteArticle(){
//		IProjectService pservice = (IProjectService) context.getBean("projectService"); 
//		Set<Project> lprojects = pservice.getAllProjects();
//		for(Project p : lprojects){
//			Article article = new Article("text");
//			article.setProject(p);
//			
//			p.addArticle(article);
//			pservice.update(p);
//			
//			break;
//		}
//		
//		//read test
//		
//		
//	}
//	
//	
//}
