//package de.christian.api.dao.test;
//
//import java.util.Set;
//
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import de.christian.api.model.Tag;
//import de.christian.api.service.interfaces.ITagService;
//
//
//
//public class TagTest {
//
//	static ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		testDeleteTags();
//		testWriteTags();
//		context.close();
//	}
//
//	public static void testWriteTags(){
//		Tag tag = new Tag("tag1");
//		Tag tag2 = new Tag("tag2");
//		ITagService tservice = (ITagService) context.getBean("tagService");		
//		tservice.save(tag);
//		tservice.save(tag2);
//		
//	}
//	
//	public static void testDeleteTags(){
//		ITagService tservice = (ITagService) context.getBean("tagService");
//		Set<Tag> ltags = tservice.getAllTags();
//		for(Tag t : ltags){
//			tservice.delete(t);
//		}
//	}
//}
