package org.jgnn.study.web.securejpa.controller;

import org.jgnn.study.web.securejpa.model.Activity;
import org.jgnn.study.web.securejpa.model.Activityresponse;
import org.jgnn.study.web.securejpa.model.Anonymous;
import org.jgnn.study.web.securejpa.model.News;
import org.jgnn.study.web.securejpa.model.Prediction;
import org.jgnn.study.web.securejpa.model.Role;
import org.jgnn.study.web.securejpa.model.Step;
import org.jgnn.study.web.securejpa.model.Stepquestion;
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

import java.security.cert.PKIXRevocationChecker.Option;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class StepsController {

	private static final int NUMBER_OF_ACTIVITY = 2;
	private static final int QDE_MIN = 5;
	private static final int SESSION_INTERAVL = 60*QDE_MIN;

	Logger logger = Logger.getLogger(StepsController.class.toString());
	
	@Autowired 
	private ActivityService activityService;
	
	@GetMapping("/exp/inst")
    public String inst(Model model, HttpServletRequest request, 
			HttpServletResponse response) {
			   
  		HttpSession session = request.getSession();
  		logger.info("Session =="+ session);     
	   
	
		//String participantAttribute = (String)session.getAttribute("participant");
  		String sessioncode = (String)session.getAttribute("sessioncode");
  		
  		model.addAttribute("sessioncode",sessioncode);
  		
		return "exp/instrucoes";
	}
	  
	@GetMapping("/exp/home")
    public String registerform(Model model, HttpServletRequest request, 
			HttpServletResponse response) {
		
		
		//String sessioncode=(String) request.getParameter("sessioncode");
		
		//System.out.println("==================================== REQUEST PARAMETER == "+sessioncode);
		HttpSession session = request.getSession();
		
		System.out.println("==================================== SESSION (exp/home) == "+session);
		
		String sessioncode = (String)session.getAttribute("participant");
		
		System.out.println("==================================== PARTICIPANT sessioncode == "+sessioncode);
		
		
		sessioncode = (String)session.getAttribute("sessioncode"); 
		System.out.println("==================================== INDEX sessioncode == "+sessioncode);
		logger.info("sessioncode(index) == "+sessioncode);
		
		if ( sessioncode==null) {
			
			System.out.println("........................CODIGO NULO................");
			
			return "exp/instrucoes";
		}
		
		model.addAttribute("sessioncode",sessioncode);
	    //Anonymous user = processUser(session);
		
		
		System.out.println("........................EXECUTOU AQUI PELO UMA VEZ...............");
		
		
		model.addAttribute("sessioncode",sessioncode);
		
		AnonymousUserProcessor processor= new AnonymousUserProcessor(activityService);
	    
		Anonymous user = processor.processUser(sessioncode);
		
		
			
		//model.addAttribute("principal", user.getUsername());
		
		Tracking tracking = activityService.findTracking(user);
		
		if (tracking ==null) {
			
			List<News> newsList = activityService.listNews();
			
			System.out.println("********* TAMANHO LISTA NEWS : "+ newsList.size()+" *************");
			
			Set<News> selectedNews = selectNews(newsList, NUMBER_OF_ACTIVITY);
			
			System.out.println("********* TAMANHO LISTA NEWS SELECTED : "+ selectedNews.size()+" *************");
			
			selectedNews.forEach( n->{
				System.out.println("     -------- new id == "+n.getId()+" ---------");
			});
			
			List<Activity> activities = createActivities(user, selectedNews);
			
			tracking = createTracking(user, activities);
			
			model.addAttribute("tacking",tracking);
			
			//String relativeURL="/exp/titulo?id="+precoAlvo.getTitulo().getId();
			//String relativeURL="/exp/act";
			
			//RedirecionadorDeRquest.redirecionarCarteira(relativeURL, request, response);  
			return "exp/index";
		}
		
		
		if(tracking.isIsover()) {
			return "exp/obrigado";
		}
		
		Activity activity = tracking.getActivity();
		
		News news = activity.getNews();
		
		String newsstory = news.getStory();
		
		model.addAttribute("newsstory",newsstory);
		
		model.addAttribute("total", NUMBER_OF_ACTIVITY);
		
		model.addAttribute("quantity",(tracking.getCompletedactivities()+1));
		
		Prediction pred = activityService.findPrediction(news);
		
		String prediction="<strong>falsa</strong>";
		
		if(pred.isRes()) {
			prediction="<strong>verdadeira</strong>";
		}
		
		model.addAttribute("prediction",prediction);
		
		long stepid = tracking.getActivity().getStep().getId();
		
		System.out.println(" (exp/home -> Stepid dentro de exp/home ==="+stepid);
		
		if(stepid==1L) {
			
			System.out.println(" (exp/home -> Stepid dentro de exp/home (encaminhou para step1.jsp)==="+stepid);
			return "exp/step1";
		}
		if(stepid==2L) {
			
			System.out.println(" (exp/home -> Stepid dentro de exp/home (encaminhou para step2.jsp)==="+stepid);
			return "exp/step2";
		}
		
		
		//model=processarParticipantes(model, activity);
		
		return "exp/step3";
		
		/*
		if(stepid==3L) {
			
			//model=processarParticipantes(model, activity);
			
			return "exp/step3";
		}
		*/
		/*
		if(stepid==4L) {
			return "exp/step4";
		}
		System.out.println(" (exp/home -> Stepid dentro de exp/home (encaminhou para step5.jsp)==="+stepid);
		return "exp/step5";
		*/
	}

	private Anonymous processUser(HttpSession session) {
		
		logger.info("Session =="+ session);
	    
	    String sessionCode = (String)session.getAttribute("participant");
	
		//User user=processUser();
	    
	    
	    if(sessionCode==null || sessionCode.contentEquals("")) {
	    	
	    	return null;
	    }
	    
	    Anonymous user = activityService.retrieveAnonymous(sessionCode);
	    
		return user;
	}

	
    @GetMapping("/exp/fase1")
    public String step1(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
    	
    	Anonymous user = processUser(session);

    	/*
    	User user=processUser();
		
		model.addAttribute("principal", user.getUsername());
		*/
    	
		Tracking tracking = activityService.findTracking(user);
		
		Activity activity = tracking.getActivity();
		
		long stepid= activity.getStep().getId();
		
		if (stepid!=1L) {
    		
			String relativeURL="/exp/home";
			RedirecionadorDeRquest.redirecionar(relativeURL, request, response);
    	}
		
		return "exp/step1";
	}
    
    /**
     * IR para step3
     * @param model
     * @param request
     * @param response
     * @param session
     */
    @GetMapping("/exp/fase2")
    public void step2(Model model, HttpServletRequest request, HttpServletResponse response) {
    	
    	HttpSession session = request.getSession();
    	
		Anonymous user = processUser(session);
		
		//model.addAttribute("principal", user.getUsername());
		
		Tracking tracking = activityService.findTracking(user);
		
		Activity activity = tracking.getActivity();
		
		long stepid= activity.getStep().getId();
		
		String stepid2= (String) request.getParameter("stepid");
		
		long currentStepid=Long.parseLong(stepid2);
		
		System.out.println();
		
		
		if (stepid!= currentStepid) {
    		
			String relativeURL="/exp/home";
			RedirecionadorDeRquest.redirecionar(relativeURL, request, response);
    	}
    	
		
		
		//Incrementar
		currentStepid=currentStepid+1;
		
		System.out.println("(/exp/fase2) -> STEP PARAMETER: "+stepid2);
		System.out.println("(/exp/fase2) -> PROXIMO STEP: "+currentStepid);
		
		Step currentStep= activityService.findStep(currentStepid);
			
		activity.setStep(currentStep);
		
		activityService.updateActivity(activity);
		
		model=addNewsstoryAttribute(model, activity);
		
		
    	String relativeURL="/exp/home";
    	
		RedirecionadorDeRquest.redirecionar(relativeURL, request, response);
		
		//return "exp/step2";
	}
    
   /**
     * Processar resosta de steps 
     * @param opinion
     * @param confia
     * @param user
     * @return 
     */
    /*
	private boolean processStep2OR4Response(long currentStepid, String opinion, String confia, User user) {
		
		//logger.info("-------ok aqui-------------");
		
		Tracking tracking = activityService.findTracking(user);
		
		Activity activity = tracking.getActivity();
		
		long stepid= activity.getStep().getId();
		
		//String newsStory = activity.getNews().getStory();
		
		logger.info("*********** Tracking : "+tracking.getId());
		
		logger.info("*********** Activity : "+activity.getId());
    	
    	logger.info("*********** Selected : "+opinion);
    	
    	//logger.info("*********** Confia : "+confia);
		
		if(stepid==currentStepid) {
			
			Step currentStep= activityService.findStep(stepid);
			
			logger.info("*********** saving ???? : ");
			saveReponse(currentStep, 1, opinion, activity);
			
			if(confia!=null) {
				
				saveReponse(currentStep, 2, confia, activity);
			}
			
			
			long nextstepid = currentStepid+1L;
			
	    	logger.info("*********** AGORA ESTA NO STEP "
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
    */
	
	
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


	private Activity updateActivity(Activity act, long stepid) {
		
		Activity activity= act;
		
		if (stepid<6) {
			
			Step currentStep= activityService.findStep(stepid);
			
			activity.setStep(currentStep);
			
			activityService.updateActivity(activity);
			
			return activity;
		}
		
		activity.setCompleted(true);
		
		activityService.updateActivity(activity);
		
		return activity;
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
    
    
    @GetMapping("/exp/fase3")
    public void step3(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
    	
    	Anonymous user = processUser(session);

    	logger.info("---------------------- /exp/fase3--------------");
    	
    	//User user=processUser();
		
		//model.addAttribute("principal", user.getUsername());
		
		Tracking tracking = activityService.findTracking(user);
		
		Activity activity = tracking.getActivity();
		
		long stepid= activity.getStep().getId();
		
		String relativeURL="/exp/home";
		
		/*
		if (stepid!=3L) {
    		
			
			RedirecionadorDeRquest.redirecionar(relativeURL, request, response);
    	}
    	*/
		//model=addNewsstoryAttribute(model, activity);
		
		logger.info("---------------------- Redirect no /exp/fase3--------------");
		RedirecionadorDeRquest.redirecionar(relativeURL, request, response);
		
		//return "exp/step3";
	}
    
    @GetMapping("/exp/fase4")
    public void step4(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
    	
    	Anonymous user = processUser(session);
		
		//model.addAttribute("principal", user.getUsername());
		
		Tracking tracking = activityService.findTracking(user);
		
		Activity activity = tracking.getActivity();
		
		long stepid= activity.getStep().getId();
		

		String relativeURL="/exp/home";
		
		if (stepid!=3L) {
    		
			
			RedirecionadorDeRquest.redirecionar(relativeURL, request, response);
    	}
		
		
		Step currentStep= activityService.findStep(stepid+1);
			
		activity.setStep(currentStep);
			
		activityService.updateActivity(activity);
	
		//model=addNewsstoryAttribute(model, activity);
    	
		RedirecionadorDeRquest.redirecionar(relativeURL, request, response);
			
		//return "exp/step4";
	
	}

	private Model addNewsstoryAttribute(Model model, Activity activity) {
		
		String newsstory = activity.getNews().getStory();
		
		model.addAttribute("newsstory",newsstory);
		
		return model;
	}
    
    @GetMapping("/exp/fase5")
    public void step5(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
    	
    	Anonymous user = processUser(session);
    	
		//model.addAttribute("principal", user.getUsername());
		
		Tracking tracking = activityService.findTracking(user);
		
		Activity activity = tracking.getActivity();
		
		long stepid= activity.getStep().getId();
		
		String relativeURL="/exp/home";
		
		if (!activity.isCompleted() && stepid!=5) {
    		
			//String relativeURL="/exp/home";
			RedirecionadorDeRquest.redirecionar(relativeURL, request, response);
    	}
		
		//model=addNewsstoryAttribute(model, activity);
		
		RedirecionadorDeRquest.redirecionar(relativeURL, request, response);
		
		//return "exp/step5";
	}


	private Tracking createTracking(Anonymous user, List<Activity> activities) { 
		
		Tracking tracking=new Tracking();
		
		Activity activity = activities.get(0);
		
		tracking.setUser(user);
		
		tracking.setActivity(activity);
		
		tracking.setIsover(false);
		
		return activityService.storeTracking(tracking);
	}


	private List<Activity> createActivities(Anonymous user, Set<News> selectedNews) {
		
		return activityService.createActivities(user, selectedNews);
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
	

	public static void shuffle(Object[] array) {
			
		Random rand = new Random();
		
		for (int i = 0; i < array.length; i++) {
			int randomIndexToSwap = rand.nextInt(array.length);
			Object temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
		}
	}
	
}
