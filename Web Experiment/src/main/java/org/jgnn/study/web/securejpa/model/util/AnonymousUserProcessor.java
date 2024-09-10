package org.jgnn.study.web.securejpa.model.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.persistence.Entity;
import javax.servlet.http.HttpSession;

import org.jgnn.study.web.securejpa.model.Activity;
import org.jgnn.study.web.securejpa.model.Anonymous;
import org.jgnn.study.web.securejpa.model.News;
import org.jgnn.study.web.securejpa.model.Step;
import org.jgnn.study.web.securejpa.model.Tracking;
import org.jgnn.study.web.securejpa.service.ActivityService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class AnonymousUserProcessor {

	private ActivityService activityService;

	public Anonymous processUser(String sessioncode ) {
	    
	    //String sessionCode = (String)sessioncode2.getAttribute("participant");
	 
	    Anonymous user = activityService.retrieveAnonymous(sessioncode);
		return user;
	}
	
	
	public Tracking obterTracking( Anonymous user, int numberOfActivies) {
		
		Tracking tracking = activityService.findTracking(user);

		if (tracking ==null) {
			
			List<News> newsList = activityService.listNews();
			
			System.out.println("********* TAMANHO LISTA NEWS : "+ newsList.size()+" *************");
			
			Set<News> selectedNews = selectNews(newsList, numberOfActivies);
			
			System.out.println("********* TAMANHO LISTA NEWS SELECTED : "+ selectedNews.size()+" *************");
			
			selectedNews.forEach( n->{
				System.out.println("     -------- new id == "+n.getId()+" ---------");
			});
			
			List<Activity> activities = activityService.createActivities(user, selectedNews);
			
			return createTracking(user, activities);
			
		}
		
		return tracking;
	}
	

	private Set<News> selectNews(List<News> lista, int numberOfActivity) {
		
		List<News> newsList= lista;
		
		Set<News> selectedNews= new HashSet<News>();
		
		Random random = new Random();
		
		for (int i=0; i<numberOfActivity; i++){
			
			Collections.shuffle(newsList);
			
			News[] newsArr = new News[newsList.size()];
			
			newsList.toArray(newsArr);
			
			int randomIndex = random.nextInt(newsArr.length);
			
			News news= (News) newsArr[randomIndex];
			
			selectedNews.add(news);
			
			newsList.remove(news);
		}
		
		return selectedNews;
	}
	

	private Tracking createTracking(Anonymous user, List<Activity> activities) { 
		
		Tracking tracking=new Tracking();
		
		Activity activity = activities.get(0);
		
		tracking.setUser(user);
		
		tracking.setActivity(activity);
		
		tracking.setIsover(false);
		
		return activityService.storeTracking(tracking);
	}

}
