package org.jgnn.study.web.securejpa.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jgnn.study.web.securejpa.model.Activity;
import org.jgnn.study.web.securejpa.model.Activityresponse;
import org.jgnn.study.web.securejpa.model.AnchorItem;
import org.jgnn.study.web.securejpa.model.Anonymous;
import org.jgnn.study.web.securejpa.model.News;
import org.jgnn.study.web.securejpa.model.Prediction;
import org.jgnn.study.web.securejpa.model.Step;
import org.jgnn.study.web.securejpa.model.Stepquestion;
import org.jgnn.study.web.securejpa.model.Topic;
import org.jgnn.study.web.securejpa.model.Tracking;



public class ActivityDao {
	
	private EntityManagerFactory entityManagerFactory;
	
	private Logger logger = Logger.getLogger("ContextListener");
	
	public ActivityDao(String persistenceUnitName ){
		
		this.entityManagerFactory 
						= Persistence.createEntityManagerFactory(persistenceUnitName);
		
	}
	
	
	
	public ActivityDao(EntityManagerFactory entityManagerFactory){
		
		this.entityManagerFactory = entityManagerFactory;
		
    }
	
	/**
	 * Listar Activities
	 * @return
	 */
	public List<Activity> list(){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        entityManager.getTransaction().begin();
		
		
		
		javax.persistence.Query query= entityManager.createQuery( "select t from Activity t", Activity.class );
		
		@SuppressWarnings("unchecked")
		List<Activity> items = (List<Activity>) query.getResultList();
		
		
	    if(items!=null) {
	        logger.info("List Size    :"+items.size());
	        
	    }
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return items;
	}
	
	
	/**
     * Obter Chamado por id
     * @param id
     * @return
     */
   
    public void persist(Activity item){
		
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
    	entityManager.getTransaction().begin();
    	
    	Activity item2= new Activity();
 		
    	Anonymous managedUser= entityManager.find(Anonymous.class, item.getUser().getId());
    	
    	News managedNews = entityManager.find(News.class, item.getNews().getId());
    	
    	Step managedStep= entityManager.find(Step.class, 1L);
    	
    	item2.setUser(managedUser);
    	
    	item2.setStep(managedStep);
    	
    	item2.setNews(managedNews);
    	
 		entityManager.persist(item2);
 		
 		entityManager.getTransaction().commit();
 		
 		entityManager.close();
   }
    
   public Activity find(Long id){
	   
	   Activity item=null;
		
	   EntityManager entityManager = entityManagerFactory.createEntityManager();
   	
	   entityManager.getTransaction().begin();
		
	   
		
	   item = entityManager.find(Activity.class, id);
		
	   entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return item;
	}
   
   
   public void update(Activity item) {
		
	   EntityManager entityManager = entityManagerFactory.createEntityManager();
	   
	   entityManager.getTransaction().begin();
	   
	   Activity item2 = entityManager.find(Activity.class,   item.getId());
	   //entityManager.refresh(ch);
		
	   Anonymous managedUser= entityManager.find(Anonymous.class, item.getUser().getId());
   	
	   	News managedNews = entityManager.find(News.class, item.getNews().getId());
	   	
	   	Step managedStep= entityManager.find(Step.class, item.getStep().getId());
	   	
	   	item2.setUser(managedUser);
	   	
	   	item2.setStep(managedStep);
	   	
	   	item2.setNews(managedNews);
	   	
	   	item2.setCompleted(item.isCompleted());
		
		entityManager.getTransaction().commit();
		entityManager.close();
   }



	public Step findStep(long stepid) {
		
		Step item=null;
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
		entityManager.getTransaction().begin();
		  
		item = entityManager.find(Step.class, stepid);
			
		   
		entityManager.getTransaction().commit();
			
			
		entityManager.close();
			
			
		return item;
	}



	/**
	 * find some activity of user
	 * @param user
	 * @return
	 */
	/*
	public List<Activity> findActivities(User user) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
        entityManager.getTransaction().begin();
		
		
		javax.persistence.Query query= entityManager.createQuery( "select t from Activity t where t.user.id=:id", Activity.class );
		
		query.setParameter("id", user.getId());
		
		@SuppressWarnings("unchecked")
		List<Activity> items = (List<Activity>) query.getResultList();
		
		
	    if(items!=null) {
	        logger.info("Actividades do usuário    :"+items.size()); 
	    }
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return items;
	}

	*/
	

	/**
	 * find some activity of user
	 * @param user
	 * @return
	 */
	public List<Activity> findActivities(Anonymous user) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
        entityManager.getTransaction().begin();
		
		
		javax.persistence.Query query= entityManager.createQuery( "select t from Activity t where t.user.id=:id", Activity.class );
		
		query.setParameter("id", user.getId());
		
		@SuppressWarnings("unchecked")
		List<Activity> items = (List<Activity>) query.getResultList();
		
		
	    if(items!=null) {
	        logger.info("Actividades do usuário    :"+items.size()); 
	    }
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return items;
	}




	public Tracking persist(Tracking item) {
		
		Tracking t =null;
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
    	entityManager.getTransaction().begin();
 		
    	Tracking item2= new Tracking();
    	
    	Anonymous managedUser= entityManager.find(Anonymous.class, item.getUser().getId());
    	
    	Activity managedActivity= entityManager.find(Activity.class, item.getActivity().getId());
    	
		item2.setUser(managedUser);
    	
    	item2.setActivity(managedActivity);
    	
 		entityManager.persist(item2);
 		
 		entityManager.getTransaction().commit();
 		
 		entityManager.close();
 		
 		t=findTracking(managedUser);
 		
		return t;
	}

	/*
	public Tracking findTracking(User user) {
		

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        entityManager.getTransaction().begin();
		
		
		javax.persistence.Query query= entityManager.createQuery( "select t from Tracking "
				+ "t where t.user.id=:id", Tracking.class );
		
		query.setParameter("id", user.getId());
		
		@SuppressWarnings("unchecked")
		List<Tracking> items = (List<Tracking>) query.getResultList();
		
		
	    Tracking item=null;
		if(items!=null && items.size()>0) {
	    	item= items.get(0);
	        logger.info("Tracking do usuário    :"+items.size()); 
	    }
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return item;
	}
	*/
	

	public Tracking findTracking(Anonymous user) {
		

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        entityManager.getTransaction().begin();
		
		
		javax.persistence.Query query= entityManager.createQuery( "select t from Tracking "
				+ "t where t.user.id=:id", Tracking.class );
		
		query.setParameter("id", user.getId());
		
		@SuppressWarnings("unchecked")
		List<Tracking> items = (List<Tracking>) query.getResultList();
		
		
	    Tracking item=null;
		if(items!=null && items.size()>0) {
	    	item= items.get(0);
	        logger.info("Tracking do usuário    :"+items.size()); 
	    }
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return item;
	}


	public Prediction findPrediction(News news) {
		
		Prediction item=null;
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        entityManager.getTransaction().begin();
		
		
		javax.persistence.Query query= entityManager.createQuery( "select e from Prediction "
				+ "e where e.news.id=:id", Prediction.class );
		
		query.setParameter("id", news.getId());
		
		@SuppressWarnings("unchecked")
		List<Prediction> items = (List<Prediction>) query.getResultList();
		
		if(items!=null && items.size()>0) {
	    	item= items.get(0);
	        logger.info("$$$ Size(lista de Predictions)    :"+items.size()); 
	    }
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return item;
	}



	public Stepquestion findStepquestion(long stepid, int questionorder) {

		Stepquestion item=null;
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        entityManager.getTransaction().begin();
		
		
		javax.persistence.Query query= entityManager.createQuery( "select e from Stepquestion "
				+ "e where e.step.id=:stepid and e.questionorder=:questionorder", Stepquestion.class );
		
		query.setParameter("stepid", stepid);
		query.setParameter("questionorder", questionorder);
		
		@SuppressWarnings("unchecked")
		List<Stepquestion> items = (List<Stepquestion>) query.getResultList();
		
		if(items!=null && items.size()>0) {
	    	item= items.get(0);
	        //logger.info("$$$ Size(lista de Predictions)    :"+items.size()); 
	    }
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return item;
	}



	public void persist(Activityresponse item) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
    	entityManager.getTransaction().begin();
    	
    	Activityresponse item2= new Activityresponse();
 		
    	Activity managedAct= entityManager.find(Activity.class, item.getActivity().getId());
    	
    	Stepquestion managedQuestion = entityManager.find(Stepquestion.class, item.getQuestion().getId());
    		
    	item2.setActivity(managedAct);
    	
    	item2.setQuestion(managedQuestion);
    	
    	item2.setResponse(item.getResponse());
    	
 		entityManager.persist(item2);
 		
 		entityManager.getTransaction().commit();
 		
 		entityManager.close();
	}



	public Activity findOpenActivity(Tracking tracking) {
		

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        entityManager.getTransaction().begin();
		
		
		
		javax.persistence.Query query= entityManager.createQuery( "select t from Activity t where "
				+ " t.user.id=:id", Activity.class );
		
		
		query.setParameter("id", tracking.getUser().getId());
		
		@SuppressWarnings("unchecked")
		List<Activity> items = (List<Activity>) query.getResultList();
		
		
		Activity item=null;
		
	    if(items!=null && items.size()>0) {
	        logger.info("List Size    :"+items.size());
	        
	        for (Activity a: items) {
	        	
	        	if (!a.isCompleted()) {
	        		
	        		item=a;
	        		
	        		break;
	        	}
	        }
	        
	    }
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return item;
	}



/*
	public void updateOLD(Tracking item) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		   
		   entityManager.getTransaction().begin();
		   
		   Tracking item2 = entityManager.find(Tracking.class,   item.getId());
		   //entityManager.refresh(ch);
			
		   User managedUser= entityManager.find(User.class, item.getUser().getId());
	   	
		   Activity managedActivity = entityManager.find( Activity.class, item.getActivity().getId());
		   	
		   
		   	item2.setUser(managedUser);
		   	
		 
		   	item2.setActivity(managedActivity);
		   	
		   	item2.setIsover(item.isIsover());
		   	
		   	item2.setCompletedactivities(item.getCompletedactivities());
			
			entityManager.getTransaction().commit();
			entityManager.close();
		
	}
*/
	public void update(Tracking item) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		   
		   entityManager.getTransaction().begin();
		   
		   Tracking item2 = entityManager.find(Tracking.class,   item.getId());
		   //entityManager.refresh(ch);
			
		   Anonymous managedUser= entityManager.find(Anonymous.class, item.getUser().getId());
	   	
		   Activity managedActivity = entityManager.find( Activity.class, item.getActivity().getId());
		   	
		   
		   	item2.setUser(managedUser);
		   	
		 
		   	item2.setActivity(managedActivity);
		   	
		   	item2.setIsover(item.isIsover());
		   	
		   	item2.setCompletedactivities(item.getCompletedactivities());
			
			entityManager.getTransaction().commit();
			entityManager.close();
		
	}



	/*
	public List<User> findUsers(Activity news) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
        entityManager.getTransaction().begin();
		
		
		javax.persistence.Query query= entityManager.createQuery( "select t from Activity t where t.news.id=:id", Activity.class );
		
		query.setParameter("id", activity.getNews().getId());
		
		@SuppressWarnings("unchecked")
		List<Activity> items = (List<Activity>) query.getResultList();
		
		
	    if(items!=null) {
	        logger.info("Actividades do usuário    :"+items.size()); 
	    }
	    if(items.size()==0) {
	   
	    	return null;
	    }
	    List<User> users= new ArrayList<User>();
	    
	    
	    for (Activity act:items) {
	    	users.add(act.getUser());
	    }
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return users;
	}
	*/
	
	public List<Activity> findActivities(News news) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
        entityManager.getTransaction().begin();
		
		
		javax.persistence.Query query= entityManager.createQuery( "select t from Activity t where t.news.id=:id", Activity.class );
		
		query.setParameter("id", news.getId());
		
		@SuppressWarnings("unchecked")
		List<Activity> items = (List<Activity>) query.getResultList();
		
		
	    if(items!=null) {
	        logger.info("Actividades do usuário    :"+items.size()); 
	    }
	    return items;
	   
	}



	public Activityresponse findActivityresponse(Activity act, Stepquestion question) {
		
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		 
        entityManager.getTransaction().begin();
		
		
		javax.persistence.Query query= entityManager.createQuery( "select t from Activityresponse t where t.question.id=:questionid "
				+ " and t.activity.id=:activityid", Activityresponse.class );
		
		query.setParameter("questionid", question.getId());
		
		query.setParameter("activityid", act.getId());
		
		@SuppressWarnings("unchecked")
		List<Activityresponse> items = (List<Activityresponse>) query.getResultList();
		
		Activityresponse item=null;
		 
	    if(items!=null) {
	        logger.info("Response size    :"+items.size()); 
	        
	        if (items.size()>0) {
	        	item= items.get(0);
	        }
	    }
	   
	    return item;
	}



	public Anonymous createAnonymous(Anonymous anonymous) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
    	entityManager.getTransaction().begin(); 	
  
 		entityManager.persist(anonymous);
 		
 		entityManager.getTransaction().commit();
 		
 		entityManager.close();
		
		return findBySession(anonymous.getSessn());
	}



	
	public Anonymous findBySession(String session) {

		Anonymous item=null;
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        entityManager.getTransaction().begin();
		
		
		javax.persistence.Query query= entityManager.createQuery( "select t from Anonymous "
				+ "t where t.sessn=:session", Anonymous.class );
		
		query.setParameter("session", session);
		
		@SuppressWarnings("unchecked")
		List<Anonymous> items = (List<Anonymous>) query.getResultList();
		
		if(items!=null && items.size()>0) {
	    	item= items.get(0);
	        logger.info("$$$ Size(lista de Anonymous)    :"+items.size()); 
	    }
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return item;
	}


	public Topic findTopic(String topic1) {

		Topic item=null;
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        entityManager.getTransaction().begin();
		
		
		javax.persistence.Query query= entityManager.createQuery( "select t from Topic "
				+ "t where t.topicnumber=:value", Topic.class );
		
		query.setParameter("value", topic1);
		
		@SuppressWarnings("unchecked")
		List<Topic> items = (List<Topic>) query.getResultList();
		
		if(items!=null && items.size()>0) {
	    	item= items.get(0);
	        logger.info("$$$ Size(lista de topic)    :"+items.size()); 
	    }
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return item;
	}



	public AnchorItem createAnchorItem(AnchorItem anchorItem) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
    	entityManager.getTransaction().begin(); 	
    	
    	AnchorItem anchorItem2=anchorItem;
    	
    	Anonymous managedAnonymous= entityManager.find(Anonymous.class, anchorItem.getAnonymous().getId());
    	
    	Topic managedTopic= entityManager.find(Topic.class, anchorItem.getTopic().getId());
    	
    	anchorItem2.setAnonymous(managedAnonymous);
    	
    	anchorItem2.setTopic(managedTopic);
    	
 		entityManager.persist(anchorItem2);
 		
 		entityManager.getTransaction().commit();
 		
 		entityManager.close();
		
		return findAnchorItem(anchorItem.getAnonymous(), anchorItem.getTopic());
	}



	private AnchorItem findAnchorItem(Anonymous anonymous, Topic topic) {

		AnchorItem item=null;
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        entityManager.getTransaction().begin();
		
		
		javax.persistence.Query query= entityManager.createQuery( "select t from AnchorItem "
				+ "t where t.topic.id=:topicid and t.anonymous.id=:anonymousid ", AnchorItem.class );
		
		query.setParameter("topicid", topic.getId());
		query.setParameter("anonymousid", anonymous.getId());
		
		@SuppressWarnings("unchecked")
		List<AnchorItem> items = (List<AnchorItem>) query.getResultList();
		
		if(items!=null && items.size()>0) {
	    	item= items.get(0);
	        logger.info("$$$ Size(lista de AnchorItem)    :"+items.size()); 
	    }
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return item;
	}



	public void update(Anonymous anonymous) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		   
		entityManager.getTransaction().begin();
		   	
	    Anonymous managedAnon= entityManager.find(Anonymous.class, anonymous.getId());   	
		   
	    managedAnon.setAnchordefined(anonymous.isAnchordefined());
		 
		entityManager.getTransaction().commit();
		
		entityManager.close();

	}


}