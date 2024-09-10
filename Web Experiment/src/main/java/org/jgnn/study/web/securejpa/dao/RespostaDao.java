package org.jgnn.study.web.securejpa.dao;


import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jgnn.study.web.securejpa.model.Resposta;



public class RespostaDao {
	
	private EntityManagerFactory entityManagerFactory;
	
	private Logger logger = Logger.getLogger("ContextListener");
	
	public RespostaDao(String persistenceUnitName ){
		
		this.entityManagerFactory 
						= Persistence.createEntityManagerFactory(persistenceUnitName);
		
	}
	
	
	
	public RespostaDao(EntityManagerFactory entityManagerFactory){
		
		this.entityManagerFactory = entityManagerFactory;
		
    }
	
	/**
	 * Listar Chamados
	 * @return
	 */
	public List<Resposta> list(){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        entityManager.getTransaction().begin();
		
		
		
		javax.persistence.Query query= entityManager.createQuery( "select t from Resposta t", Resposta.class );
		
		@SuppressWarnings("unchecked")
		List<Resposta> compras = (List<Resposta>) query.getResultList();
		
		
	    if(compras!=null) {
	        logger.info("List Size    :"+compras.size());
	        
	    }
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return compras;
	}
	
	
	/**
     * Obter Chamado por id
     * @param id
     * @return
     */
   
    public void persist(Resposta compra){
		
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
    	entityManager.getTransaction().begin();
 		
 		
 		
 		entityManager.persist(compra);
 		
 		
 		entityManager.getTransaction().commit();
 		
 		entityManager.close();
 		
	}
    
    
   public void remove(Resposta compra){
		
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
    	entityManager.getTransaction().begin();
 		
 		
 		
    	Resposta managedCompra = entityManager.find(Resposta.class, compra.getId());
 		
 		entityManager.remove(managedCompra);
 		
 		entityManager.getTransaction().commit();
 		
 		entityManager.close();
	}
   
   
   public Resposta find(Long id){
	   
	   Resposta comora=null;
		
	   EntityManager entityManager = entityManagerFactory.createEntityManager();
   	
	   entityManager.getTransaction().begin();
		
	   
		
	   comora = entityManager.find(Resposta.class, id);
		
	   entityManager.getTransaction().commit();
		
		entityManager.close();
		
		return comora;
	}
   
   
   public void update(Resposta compra) {
		
	   EntityManager entityManager = entityManagerFactory.createEntityManager();
	   
	   entityManager.getTransaction().begin();
	   
	   Resposta cpr = entityManager.find(Resposta.class,   compra.getId());
	   //entityManager.refresh(ch);
		
		
		
		/*
		cpr.setTitulo(compra.getTitulo());
		cpr.setData(compra.getData());
		cpr.setQuantidade(compra.getQuantidade());
		cpr.setPrecounitario(compra.getPrecounitario());
		cpr.setTaxa(compra.getTaxa());
		cpr.setTotal(compra.getTotal());
		*/
		entityManager.getTransaction().commit();
		entityManager.close();
   }





	public List<Resposta> listar() {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        entityManager.getTransaction().begin();
		
		System.out.println("Begin Transaction.. Aportes........................");
		
		javax.persistence.Query query= entityManager.createQuery( "select t from Resposta t", Resposta.class );
		
		@SuppressWarnings("unchecked")
		List<Resposta> aportes = (List<Resposta>) query.getResultList();
		
		/*
	    if(aportes!=null) {
	        logger.info("Aportes List Size    :"+aportes.size());
	        
	    }
	    */
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		
		//<Tituloativo> tituloativos = tativos.stream().sorted() .collect(Collectors.toList());
		//ordenar
		return aportes.stream().sorted() .collect(Collectors.toList());
	}
}