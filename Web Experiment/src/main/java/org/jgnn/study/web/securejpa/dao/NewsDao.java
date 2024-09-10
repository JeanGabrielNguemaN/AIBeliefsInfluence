package org.jgnn.study.web.securejpa.dao;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.jgnn.study.web.securejpa.model.News;

public class NewsDao {

	EntityManagerFactory entityManagerFactory;
	
	private Logger logger = Logger.getLogger("ContextListener");
	
	public NewsDao(EntityManagerFactory emf) {
	 
		this.entityManagerFactory=emf;	
	}
	
	public List<News> list(){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        entityManager.getTransaction().begin();
		
		javax.persistence.Query query= entityManager.createQuery( "select t from News t", News.class );
		
		@SuppressWarnings("unchecked")
		List<News> items = (List<News>) query.getResultList();
		
		
	    if(items!=null) {
	        logger.info("List Size    :"+items.size());
	        
	    }
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return items;
	}
	
	   public News find(Long l){
		   
		   News empresa=null;
			
		   EntityManager entityManager = entityManagerFactory.createEntityManager();
	   	
		   entityManager.getTransaction().begin();
			
		   
			
		   empresa = entityManager.find(News.class, l);
			
		   entityManager.getTransaction().commit();
		   
		   System.out.println("End Transaction..........................");
		   
		   entityManager.close();
			
		   return empresa;
		}
}
