package de.christian.api.dao.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.christian.api.model.News;
import de.christian.api.model.Tag;
import de.christian.api.service.NewsServiceImpl;
import de.christian.api.service.interfaces.INewsService;
import de.christian.api.service.interfaces.ITagService;



public class NewsTest {

//	static ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//	
//	NewsServiceImpl nservice;
//	
//	public static void main(String[] args) {
////		testDeleteNews();
////		testDeleteNewsWithoutTags();
//		testWriteNews();
//		testAddTags();
////		testRemoveTags();
//		context.close();
//	}
//	
//	public static void testWriteNews(){
//		News news1 = new News("title5","<p>The <code>:last-child</code> selector allows you to target the last element directly inside its containing element. It is defined in the <a href='http://www.w3.org/TR/selectors/'>CSS Selectors Level 3 spec</a> as a “structural pseudo-class”, meaning it is used to style content based on its relationship with parent and sibling content.</p><p>Suppose we have an article and want to make the last paragraph smaller, to act as a conclusion to the content (like an editor's note):</p><pre class=' language-markup' rel='HTML'><code class=' language-markup'><span class='token tag'><span class='token tag'><span class='token punctuation'>&lt;</span>article</span><span class='token punctuation'>&gt;</span></span>  <span class='token tag'><span class='token tag'><span class='token punctuation'>&lt;</span>p</span><span class='token punctuation'>&gt;</span></span>Lorem ipsum...<span class='token tag'><span class='token tag'><span class='token punctuation'>&lt;/</span>p</span><span class='token punctuation'>&gt;</span></span>  <span class='token tag'><span class='token tag'><span class='token punctuation'>&lt;</span>p</span><span class='token punctuation'>&gt;</span></span>Dolor sit amet...<span class='token tag'><span class='token tag'><span class='token punctuation'>&lt;/</span>p</span><span class='token punctuation'>&gt;</span></span>  <span class='token tag'><span class='token tag'><span class='token punctuation'>&lt;</span>p</span><span class='token punctuation'>&gt;</span></span>Consectetur adipisicing...<span class='token tag'><span class='token tag'><span class='token punctuation'>&lt;/</span>p</span><span class='token punctuation'>&gt;</span></span>  <span class='token tag'><span class='token tag'><span class='token punctuation'>&lt;</span>p</span><span class='token punctuation'>&gt;</span></span>Last paragraph...<span class='token tag'><span class='token tag'><span class='token punctuation'>&lt;/</span>p</span><span class='token punctuation'>&gt;</span></span><span class='token tag'><span class='token tag'><span class='token punctuation'>&lt;/</span>article</span><span class='token punctuation'>&gt;</span></span></code></pre><p>Instead of using a class (e.g. <code>.last</code>), we can use <code>:last-child</code> to select it:</p><pre class=' language-css' rel='CSS'><code class=' language-css'><span class='token selector'>p<span class='token pseudo-class'>:last-child</span> </span><span class='token punctuation'>{</span>  <span class='token property'>font-size</span><span class='token punctuation'>:</span> 0.75em<span class='token punctuation'>;</span><span class='token punctuation'>}</span></code></pre><p>Using <code>:last-child</code> is very similar to <code>:last-of-type</code> but with one <b>critical difference:</b> it is <a href='http://css-tricks.com/the-difference-between-nth-child-and-nth-of-type/'>less specific</a>. <code>:last-child</code> will only try to match the very last child of a parent element, while <code>last-of-type</code> will match the last occurrence of a specified element, even if it doesn't come dead last in the HTML. In the example above the outcome would be the same, only because the last child of the <code>article</code> also happens to be the last <code>p</code> element. This reveals the power of <code>:last-child</code>: it can identify an element with relation to all of its siblings, <i>not just siblings of the same type</i>.</p><p>The more complete example below demonstrates the use of <code>:last-child</code> and a related pseudo-class selector, <a href='http://css-tricks.com/almanac/selectors/f/first-child'><code>:first-child</code></a>.</p>");
//		News news2 = new News("title6","text");
//	
//		INewsService nservice = (INewsService) context.getBean("newsService");
//		nservice.save(news1);
//		nservice.save(news2);
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
////			ArrayList<Tag> tags = new  ArrayList<Tag>(n.getTags());
////			for(Tag t : ltags){
//				
////				tags.add(t);
//				n.setTags(ltags);
//				
////			}
////			n.setTags(new HashSet<Tag>(tags));
//			
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
//	public static void testRemoveTags(){
//		INewsService nservice = (INewsService) context.getBean("newsService");
//		Set<News> lnews = nservice.getAllNews();
//		for(News n : lnews){
////			Tag tag = new Tag("tag3");
////			Tag tag2 = new Tag("tag4");
////			n.getTags().remove(tag);
////			n.getTags().remove(tag2);
//			n.getTags().clear();
//			nservice.update(n);
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
//	public static void testDeleteNewsWithoutTags(){
//		INewsService nservice = (INewsService) context.getBean("newsService");
//		Set<News> lnews = nservice.getAllNews();
//		for(News n : lnews){
////			ITagService tservice = (ITagService) context.getBean("tagService");
////			Set<Tag> ltags = tservice.getAllTags();
////			for(Tag t : ltags){
////				t.
////			}
////			nservice = (INewsService) context.getBean("newsService");
//			n.getTags().clear();
//			nservice.delete(n);
//		}
//	}
//	
//	public static void testDeleteNews(){
//		INewsService nservice = (INewsService) context.getBean("newsService");
//		Set<News> lnews = nservice.getAllNews();
//		for(News n : lnews){
//			
//			nservice.delete(n);
//		}
//	}
//	
	
	

}
