package org.jgnn.study.web.securejpa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpSession;

import org.jgnn.study.web.securejpa.dao.ActivityDao;
import org.jgnn.study.web.securejpa.dao.NewsDao;

import org.jgnn.study.web.securejpa.model.Activity;
import org.jgnn.study.web.securejpa.model.Activityresponse;
import org.jgnn.study.web.securejpa.model.AnchorItem;
import org.jgnn.study.web.securejpa.model.Anonymous;
import org.jgnn.study.web.securejpa.model.News;
import org.jgnn.study.web.securejpa.model.Prediction;
import org.jgnn.study.web.securejpa.model.Resposta;
import org.jgnn.study.web.securejpa.model.Step;
import org.jgnn.study.web.securejpa.model.Stepquestion;
import org.jgnn.study.web.securejpa.model.Topic;
import org.jgnn.study.web.securejpa.model.Tracking;

import org.jgnn.study.web.securejpa.model.util.Participant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class ActivityService {

	private ActivityDao activityDao;
	
	private NewsDao newsDao;
	
	public ActivityService(ActivityDao empresaDao, NewsDao newsDao) {
		this.activityDao=empresaDao;
		this.newsDao=newsDao;
	}
	
	public ActivityService(ActivityDao activityDao) {
		this.activityDao=activityDao;
	}

	public List<Activity> list() {

		return activityDao.list();
	}
	
	public List<News> listNews() {

		return newsDao.list();
	}
	
	public void  save(Activity item) {

		activityDao.persist(item);
	}

	
	
	

	public List<Activity> createActivities(Anonymous user, Set<News> selectedNews) {
		
		//Step step1 = activityDao.findStep(1L);
		
		
		selectedNews.forEach(news -> {
			
			Activity activity= new Activity();
			
			activity.setUser(user);
			
			activity.setNews(news);
			
			activityDao.persist(activity);
		});
		
		
		return activityDao.findActivities(user);
	}


	public Tracking storeTracking(Tracking tracking) {
		
		return activityDao.persist(tracking);
	}

	/*
	public Tracking findTracking(User user) {
		
		return activityDao.findTracking(user);
	}
	*/

	public Tracking findTracking(Anonymous user) {
		
		return activityDao.findTracking(user);
	}

	public Step findStep(long stepid) {
		
		return activityDao.findStep(stepid);
	}

	public void updateActivity(Activity activity) {
		activityDao.update(activity);
	}

	
	public Prediction findPrediction(News news) {
		
		return activityDao.findPrediction(news);
	}

	public void save(Activityresponse item) {
		
		activityDao.persist(item);
		
	}

	public Stepquestion findStepquestion(long stedid, int questionorder) {
		
		
		
		return activityDao.findStepquestion(stedid, questionorder);
	}

	public Activity findOpenActivity(Tracking tracking) {
		
		return activityDao.findOpenActivity(tracking);
	}

	public void updateTracking(Tracking tracking) {
		
		activityDao.update(tracking);
		
	}

	/**
	 * Quem opinou sobre uma noticia
	 * @param news
	 * @return
	 */
	public List<Participant> retrieveParticipants(News news) {
		
		List<Activity> activities= activityDao.findActivities(news);
		
		if (activities==null || (activities!=null && activities.size()==0)) {
			return null;
		}
		
		List<Participant> participants=new ArrayList<Participant>();
		
		for (Activity act: activities) {
			
			//passo 4 respondido
			if (act.getStep().getId()==5) {
				
				Participant participant= new Participant();
				
				Anonymous user = act.getUser();
				
				//participant.setNome(user.getUsername());
				
				
				
				//obter resposta do step 4
				long stepid=4;
				int questionorder=1;
				
				Stepquestion question= activityDao.findStepquestion(stepid, questionorder);
				Activityresponse reponse= activityDao.findActivityresponse(act,question);
				
				participant.setJulgamento(reponse.getResponse());
				
				participants.add(participant);
				
				//System.out.println(" ++++++++++++++++++++++ ADDICIONOU PARTICIPANTE ++++++++++++++++++++++");
			}
		}
		
		return participants;
	}

	public Anonymous createAnonymous(String sexo, String idade, String estadocivil, String escolaridade, String renda,
			String sessionCode) {
		
		Anonymous anonymous = activityDao.findBySession(sessionCode);
		
		if (anonymous!=null) {
			return anonymous;
		}
		
		anonymous = new Anonymous(0, sexo, idade, estadocivil, escolaridade,renda, sessionCode, false);
		
		
		
		return activityDao.createAnonymous(anonymous);
	}

	public Anonymous retrieveAnonymous(String sessionCode) {
		
		return activityDao.findBySession(sessionCode);
		
	}

	public Topic retrieveTopic(String topic1) {
		
		return activityDao.findTopic(topic1);
	}

	public AnchorItem createAnchorItem(AnchorItem anchorItem) {
		
		return activityDao.createAnchorItem(anchorItem);
	}

	public void update(Anonymous anonymous) {
		activityDao.update(anonymous);

	}
}