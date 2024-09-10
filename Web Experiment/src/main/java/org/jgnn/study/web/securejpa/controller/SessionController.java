package org.jgnn.study.web.securejpa.controller;

import org.jgnn.study.web.securejpa.RandomNumberGerator;
import org.jgnn.study.web.securejpa.model.Activity;
import org.jgnn.study.web.securejpa.model.Activityresponse;
import org.jgnn.study.web.securejpa.model.AnchorItem;
import org.jgnn.study.web.securejpa.model.Anonymous;
import org.jgnn.study.web.securejpa.model.News;
import org.jgnn.study.web.securejpa.model.Prediction;
import org.jgnn.study.web.securejpa.model.Role;
import org.jgnn.study.web.securejpa.model.Step;
import org.jgnn.study.web.securejpa.model.Stepquestion;
import org.jgnn.study.web.securejpa.model.Topic;
import org.jgnn.study.web.securejpa.model.Tracking;
import org.jgnn.study.web.securejpa.model.util.AnonymousUserProcessor;
import org.jgnn.study.web.securejpa.model.util.Participant;
import org.jgnn.study.web.securejpa.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javassist.bytecode.analysis.Analyzer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.security.cert.PKIXRevocationChecker.Option;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

	private static final int QDE_MIN = 5;
	private static final int SESSION_INTERAVL = 60*QDE_MIN;
	private static final int NUMBER_OF_ACTIVITY = 2;
	private static final int NUMBER_OF_STEPS = 3;
	
	@Resource(name = "randomNumberGerator")
    RandomNumberGerator randomNumberGerator;
	
	Logger logger = Logger.getLogger(SessionController.class.toString());

	@Autowired
	private ActivityService activityService;
	
	
	@GetMapping("/exp")
    synchronized public String init(ModelMap model, HttpServletRequest request, HttpServletResponse response) {   
		
		int randomNumber = randomNumberGerator.getNextRandomNumber();
		
		String sessioncode = (String) model.getAttribute("sessioncode");
		
		if(sessioncode!=null && !sessioncode.trim().contentEquals("")) {
			
			model.addAttribute("sessioncode",sessioncode);
			
			//NOVO
			HttpSession session = request.getSession();
			
			session.setAttribute("sessioncode",sessioncode);
			
			return "exp/instrucoes";
		}
		
		sessioncode="";
		
		randomNumber = randomNumberGerator.getNextRandomNumber();
  	   
  		HttpSession session = request.getSession();
  		logger.info("Session =="+ session);     
	   
	
		//String participantAttribute = (String)session.getAttribute("participant");
  		String participantAttribute = (String)session.getAttribute("sessioncode");
		
		logger.info("ANTES IF Session do Participant (INIT METHOD) == "+ participantAttribute);
		
		if(participantAttribute==null) {
			
			logger.info("Session do Participant == NULL (INIT METHOD)");
			
			logger.info("Ainda não tem...");
			//session=request.getSession(true);
			
			session.setMaxInactiveInterval(SESSION_INTERAVL);	
			
			LocalDateTime now = LocalDateTime.now();
			
			
			sessioncode=sessioncode+now+"-"+randomNumber;
			
			
			logger.info("NOW criado (NO IF) == "+sessioncode);
			
			//session.setAttribute("participant", ""+sessioncode);
			
			session.setAttribute("sessioncode", ""+sessioncode);
			
			//participantAttribute = (String)session.getAttribute("participant");
			
			participantAttribute = (String)session.getAttribute("sessioncode");
			 
			
		}
		System.out.println("==================================== SESSION (exp/) == "+session);
		logger.info("Session code FINAL (INIT METHOD) == "+participantAttribute);
		model.addAttribute("sessioncode",participantAttribute);
		
		return "exp/home";
	
	 }
	
	@GetMapping("/exp/participe")
    public String demoform(@RequestParam("sessioncode") String sessioncode, ModelMap model, HttpServletRequest request, 
    		HttpServletResponse response) {   
		
		 model.addAttribute("sessioncode",sessioncode);
		
		 Anonymous anonymous= activityService.retrieveAnonymous(sessioncode);
		    
		 if(anonymous!=null) {
		    	
			 String relativeURL="/exp/home";
			 if(anonymous.isAnchordefined()) {
					RedirecionadorDeRquest.redirecionar(relativeURL, request, response); 
			 }
		    
			 relativeURL="/exp/anchor";
			 RedirecionadorDeRquest.redirecionar(relativeURL, request, response);
		    }
		
		
	   
		HttpSession session = request.getSession();
		//logger.info("Session =="+ session);
		
		String participantAttribute = (String) session.getAttribute("participant");
		logger.info("Session do Participant == "+participantAttribute);
		logger.info("SESSION CODE == "+sessioncode);
		
		model.addAttribute("sessioncode",sessioncode);
		
		
		return "exp/demogform";
	
	 }
	 
	 @GetMapping("/exp/demoadd")
	 public synchronized String demo(@RequestParam("sessioncode") String sessioncode, @RequestParam("sexo") String sexo,
			 @RequestParam("estadocivil") String estadocivil, @RequestParam("radioidade") String idade, 
			 @RequestParam("escolaridade") String escolaridade, 
			 @RequestParam("renda") String renda, ModelMap model, HttpServletRequest request, HttpServletResponse response) {       
		    
		 model.addAttribute("sessioncode",sessioncode);
		 
	     String msg="Sexo="+sexo+"\n"
					  	+"Estado civil ="+estadocivil+"\n"
					  	+"Idade ="+idade+"\n"
					  	+"Escolaridade ="+escolaridade+"\n"
					  	+"Renda ="+renda+"\n";
			 
	      System.out.println("====================PARAMETROS : "+msg+" ================");
		  logger.info(msg);
		    
		    /*
		    HttpSession session = request.getSession();
		    
		    //logger.info("Session =="+ session);
		    
		    //String sessionCode = (String)session.getAttribute("participant");
		    
		    /*
			
			if(sessionCode==null) {
				
				 logger.info("Participant == NULL");
				 
				 return "init";
			}
		     
			 //logger.info("New Session =="+ session);
			 
			 //logger.info("Participant == "+ sessionCode);
			 */
			 Anonymous participant = activityService.createAnonymous(sexo,idade,estadocivil,escolaridade,renda,sessioncode)	;
		        
		     //session.setAttribute("anonymous", participant);
			/*
			LocalDateTime now = LocalDateTime.now();
		    System.out.println("Before formatting: " + now);
		    DateTimeFormatter nowformatted = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		    String formattedDate = now.format(nowformatted);
		    
		    System.out.println("After formatting: " + formattedDate);
		    
		    */
		    model.addAttribute("message",msg);
		    
	   return "exp/anchor"; 	
	 }
	 
	 
	 @GetMapping("/exp/anchoradd")
	 public synchronized  String atualizarAnchor(@RequestParam("sessioncode") String sessioncode, @RequestParam("topic1") String topic1,
			 @RequestParam("topic2") String topic2, @RequestParam("topic3") String topic3, 
			 @RequestParam("topic4") String topic4, @RequestParam("topic5") String topic5, 
			 @RequestParam("topic6") String topic6, @RequestParam("topic7") String topic7, 
			 @RequestParam("topic8") String topic8, ModelMap model, 
			 HttpServletRequest request, HttpServletResponse response) {       
		   
		 
		 model.addAttribute("sessioncode",sessioncode);
		 
	    	String msg="topic1 ="+topic1+"\n"
					  	+"topic2 ="+topic2+"\n"
					  	+"topic3 ="+topic3+"\n"
					  	+"topic4 ="+topic4+"\n"
					  		;
			
	    	//System.out.println("====================PARAMETROS : "+msg+" ================");
	    	
		    //logger.info(msg);
		    

	    	/*
		    HttpSession session = request.getSession();
		    
		    logger.info("Session CODE =="+ session);
		    
		    String sessionCode = (String)session.getAttribute("participant");
		    
		    logger.info("Participant CODE =="+ sessionCode);
	    	
		    */
		    Anonymous anonymous= activityService.retrieveAnonymous(sessioncode);
		    
		    
		    String[] topics= new String[]{"topic1","topic2","topic3","topic4",
		    		"topic5","topic6","topic7","topic8"};
		    
		    Set<AnchorItem> anchor= new HashSet<AnchorItem>();
		    
		    int it=0;
		    for(String top_: topics) {
		    	
		    	it++;
		    	
		    	String top=top_.trim();
		    	Topic topic= activityService.retrieveTopic(top);
		    	
		    	String rsponse = obterValorTopic(topic1, topic2, topic3, topic4, topic5, topic6, topic7, topic8,it, top);
		    	
		    	AnchorItem anchorItem= new AnchorItem(0, anonymous, topic, rsponse);
		    	
		    	msg=top_;
		    	logger.warning("ITERAÇAO "+it);
		    	logger.warning(msg);
		    	//logger.warning("Session CODE =="+ session);
			   // logger.warning("Participant CODE =="+ sessionCode);
			    logger.warning("ANONYMOUS ID ==== "+anonymous);
			    logger.warning("ANCHOR ITEM ==== {\n"
			    		+ "topic: "+anchorItem.getTopic()
			    		+ "response: "+anchorItem.getResponse()
			    		+"\n}");
			    
		    	 anchorItem=activityService.createAnchorItem(anchorItem);
		    	 
		    	 anchor.add(anchorItem);
		    	
		    }
		    
		    anonymous.setAnchordefined(true);
		    activityService.update(anonymous);
		    //anonymous.setAnchor(anchor);
		    
		    AnonymousUserProcessor processor= new AnonymousUserProcessor(activityService);
		    
		    Anonymous user = processor.processUser(sessioncode);
			
			Tracking tracking =processor.obterTracking(user,  NUMBER_OF_ACTIVITY);
			
			model.addAttribute("tacking",tracking);
			
			Activity activity = tracking.getActivity();
			
			News news = activity.getNews();
			
			String newsstory = news.getStory();
			
			model.addAttribute("newsstory",newsstory);
			
			model.addAttribute("total", NUMBER_OF_ACTIVITY);
			
			model.addAttribute("quantity",(tracking.getCompletedactivities()+1));
			
			long stepid= activity.getStep().getId();
			
			if (stepid!=1L) {
	    		
				String relativeURL="/exp/home";
				RedirecionadorDeRquest.redirecionar(relativeURL, request, response);
	    	}
		    
	   return "exp/step1"; 	
	 }

	private String obterValorTopic(String topic1, String topic2, String topic3, String topic4,
			String topic5, String topic6, String topic7, String topic8, int it, String top) {
		
		String rsponse=top;
		
		switch (it) {
		
		case 1: rsponse=topic1;
			
			break;
		case 2: rsponse=topic2;
		
			break;
		case 3: rsponse=topic3;
		
			break;
		case 4: rsponse=topic4;
		
			break;
			
		case 5: rsponse=topic5;
		
			break;
		case 6: rsponse=topic6;
	
			break;
	
		case 7: rsponse=topic7;
	
			break;
	
		case 8: rsponse=topic8;
	
			break;
		
		default:
			break;
		}
		return rsponse;
		
	}
	 
	 
	 
	 @GetMapping("/exp/step1/answer")
	 public String processStep1(@RequestParam("topic1") String topic1,
			 @RequestParam("topic2") String topic2, @RequestParam("topic3") String topic3, 
			 @RequestParam("topic4") String topic4,  @RequestParam("topic5") String topic5,
			 @RequestParam("topic6") String topic6, @RequestParam("topic7") String topic7, 
			 @RequestParam("topic8") String topic8, 
			 ModelMap model, HttpServletRequest request, HttpServletResponse response) {       
		   
	    	String msg="topic1 ="+topic1+"\n"
					  	+"topic2 ="+topic2+"\n"
					  	+"topic3 ="+topic3+"\n"
					  	+"topic4 ="+topic4+"\n"
					  		;
			
	    	System.out.println("====================PARAMETROS : "+msg+" ================");
		    logger.info(msg);
		    

		    HttpSession session = request.getSession();
		    
		    logger.info("Session =="+ session);
		    
		    String sessionCode = (String)session.getAttribute("participant");
	    	
		    Anonymous anonymous= activityService.retrieveAnonymous(sessionCode);
		    
		    
		    String[] topics= new String[]{"topic1","topic2","topic3","topic4",
		    		"topic5","topic6","topic7","topic8"};
		    
		    Set<AnchorItem> anchor= new HashSet<AnchorItem>();
		    
		    for(String top: topics) {
		    	
		    	 Topic topic= activityService.retrieveTopic(top);
				    
				    
		    	 String rsponse=topic1;
				    
				    
		    	 AnchorItem anchorItem= new AnchorItem(0, anonymous, topic, rsponse);
		    	 
		    	 anchorItem=activityService.createAnchorItem(anchorItem);
		    	 
		    	 anchor.add(anchorItem);
		    	
		    }
		    
		   // anonymous.setAnchor(anchor);
			 
		    model.addAttribute("message",msg
		    		+"\nAnonymous: "+anonymous.getSessn()
		    		//+"\nAnchor topic1: "+anonymous.getAnchor().iterator().next()
		    		+ "");
		    
	   return "exp/step2"; 	
	 }
	 
	 @GetMapping("/exp/fase1/save")
	 public String step2save(@RequestParam("sessioncode") String sessioncode,
			 @RequestParam("stepid") String stepid, @RequestParam("opinion") String opinion,
	    		@RequestParam("confianca") String confia, Model model, 
	    		HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	    	
		 model.addAttribute("sessioncode",sessioncode);
		 
		 AnonymousUserProcessor processor= new AnonymousUserProcessor(activityService);
		    
		 Anonymous user = processor.processUser(sessioncode);
			
		 Tracking tracking =processor.obterTracking(user,  NUMBER_OF_ACTIVITY);
			
		 model.addAttribute("tacking",tracking);
			
		 Activity activity = tracking.getActivity();
	    	
		 String relativeURL="/exp/fase2";
	    	
	    	
		 if ((opinion==null || confia==null)) {
	    		
				RedirecionadorDeRquest.redirecionar(relativeURL, request, response);
	    	
		 }
	    	
	    	
		 if (opinion!=null && opinion.trim().contentEquals("")) {
	    		
				RedirecionadorDeRquest.redirecionar(relativeURL, request, response);
	    	
		 }
	    	
	    	
		 if (confia!=null && confia.trim().contentEquals("")) {
				
				RedirecionadorDeRquest.redirecionar(relativeURL, request, response);
	    	
		 }
	    
	    
		
	    	
		 //User user=processUser();
			
			
		 //model.addAttribute("principal", user.getUsername());
			
		 //long currentStepid=1L;
		 
		 long currentStepid=Long.parseLong(stepid);
		 
		 System.out.println("(exp/fase1/save) --> CURRENT STED ID = "+currentStepid);
			
		 boolean result = processStep2OR4Response(currentStepid, opinion, confia, user);
			
		 if(result) {
			 
			 System.out.println("(exp/fase1/save) --> DENTRO IF RESULT");
			 
			 model=addAtributtes(model, tracking, activity);	
				
			 //RedirecionadorDeRquest.redirecionar(relativeURL, request, response);
		
			 return "exp/index";
		 }
			
		 return "exp/error";
	 }

	private Model addAtributtes(Model model, Tracking tracking, Activity activity) {
		model.addAttribute("activity", activity);
		 
		 model.addAttribute("total", NUMBER_OF_ACTIVITY);
			
			
		 model.addAttribute("quantity",(tracking.getCompletedactivities()+1));
		 
		 return model;
	}
	 
	 
	 
	 /**
	     * Processar resosta de steps 
	     * @param opinion
	     * @param confia
	     * @param user
	     * @return 
	     */
	    
		private boolean processStep2OR4Response(long currentStepid, String opinion, String confia, Anonymous user) {
			
			logger.info("-------ok aqui-------------");
			
			Tracking tracking = activityService.findTracking(user);
			
			Activity activity = tracking.getActivity();
			
			long stepid= activity.getStep().getId();
			
			//String newsStory = activity.getNews().getStory();
			
			logger.info("*********** Tracking : "+tracking.getId());
			
			logger.info("*********** Activity : "+activity.getId());
	    	
	    	logger.info("*********** Selected : "+opinion);
	    	
	    	//logger.info("*********** Confia : "+confia);
	    	
	    	logger.info("-------PROCESSSANDO  -------------"+stepid);
			
			if(stepid==currentStepid) {
				
				Step currentStep= activityService.findStep(stepid);
				
				logger.info("*********** SAVING step = "+stepid
						+ "???? : ");
				
				int questionorder=1;
				saveReponse(currentStep, questionorder, opinion, activity);
				
				questionorder=2;
				
				if(confia!=null) {
					
					saveReponse(currentStep, questionorder, confia, activity);
				}
				
				
				long nextstepid = currentStepid+1L;
				
		    	logger.info("*********** PROXIMO STEP "
		    			+ nextstepid+ ": ..........................");

		    	Activity udaptedActivity = updateActivity(activity, nextstepid);
			
				
		    	tracking.setActivity(activity);
		    	
				if (udaptedActivity.isCompleted()) {
					
					updateTracking(tracking);
					
				}
		    	return true;
			}
			
			return false;
			
		}
	 
		
		private Activityresponse saveReponse(Step currentStep, int questionorder, String opinion, Activity activity) {

			logger.info(" ----------- Chegou aqui: salvou response --------------");
			
			Activityresponse activityresponse= new Activityresponse();
			
			activityresponse.setActivity(activity);
			
			Stepquestion stepquestion= activityService.findStepquestion(currentStep.getId(), questionorder);
			
			activityresponse.setQuestion(stepquestion);
			
			activityresponse.setResponse(opinion);
			
			activityService.save(activityresponse);
			
			return activityresponse;
		}
		
		private Activity updateActivity(Activity act, long stepid) {
			
			Activity activity= act;
			
			if (stepid<(NUMBER_OF_STEPS+1)) {
				
				Step currentStep= activityService.findStep(stepid);
				
				activity.setStep(currentStep);
				
				activityService.updateActivity(activity);
				
				return activity;
			}
			
			activity.setCompleted(true);
			
			activityService.updateActivity(activity);
			
			return activity;
		}
		
		
		private void updateTracking(Tracking tracking) {
			
			logger.info("-------------update stracking---------------");
			
			Activity activity=activityService.findOpenActivity(tracking);
			
			if (activity!=null) {
				
				logger.info("-------------activity: "
						+ activity.getId()+"--------------");
				
				logger.info("------------- Completed? "
						+ activity.isCompleted()+"---------------");
				
				logger.info("-------------update stracking---------------");
				
				tracking.setActivity(activity);
				
				//Atualizar atividades completadas
				tracking.setCompletedactivities(tracking.getCompletedactivities()+1);
									
				activityService.updateTracking(tracking);
				
				return ;
			}
			

			tracking.setIsover(true);
			
			activityService.updateTracking(tracking);
			
		}
		
		
		@GetMapping("/exp/contato")
	    public String contato(ModelMap model, HttpServletRequest request, HttpServletResponse response) {   
			
				return "exp/contato";
		}
}
