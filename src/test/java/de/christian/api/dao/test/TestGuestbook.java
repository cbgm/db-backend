//package de.christian.api.dao.test;
//
//import java.util.Date;
//import java.util.Set;
//
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import de.christian.api.model.GuestbookEntry;
//import de.christian.api.service.interfaces.IGuestbookEntryService;
//
//
//
//public class TestGuestbook {
//
//	static ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		testWriteGuestbookEntry();
////		testGetByNameGuestbookEntry();
////		testDeleteGuestbookEntries();
//	}
//
//	
//	public static void testWriteGuestbookEntry(){
//		GuestbookEntry  entry1 = new GuestbookEntry("alex","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, ",new Date());
////		GuestbookEntry entry2 = new GuestbookEntry("alex","neuer eintrag2",new Date());
//		IGuestbookEntryService gservice = (IGuestbookEntryService) context.getBean("guestbookEntryService");		
//		
//		gservice.save(entry1);
////		gservice.save(entry2);
//		
//		Set<GuestbookEntry> entries = gservice.getAllGuestbookEntries();
//		for(GuestbookEntry e : entries){
//			System.out.println(e.toString());
//		}
//		
//	}
//	
//	public static void testGetByNameGuestbookEntry(){
//		IGuestbookEntryService gservice = (IGuestbookEntryService) context.getBean("guestbookEntryService");		
//		
//		
//		Set<GuestbookEntry> entries = gservice.getEntriesByAuthor("alex");
//		for(GuestbookEntry e : entries){
//			System.out.println(e.toString());
//		}
//		
//	}
//	
//	public static void testDeleteGuestbookEntries(){
//		IGuestbookEntryService gservice = (IGuestbookEntryService) context.getBean("guestbookEntryService");		
//		
//		
//		Set<GuestbookEntry> entries = gservice.getEntriesByAuthor("alex");
//		for(GuestbookEntry e : entries){
//			gservice.delete(e);
//		}
//		
//	}
//
//}
