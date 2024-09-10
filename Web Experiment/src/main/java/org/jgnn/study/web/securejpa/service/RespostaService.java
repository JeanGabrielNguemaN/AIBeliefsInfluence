package org.jgnn.study.web.securejpa.service;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.jgnn.study.web.securejpa.dao.RespostaDao;
import org.jgnn.study.web.securejpa.model.Resposta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class RespostaService {

	private RespostaDao empresaDao;
	private EntityManagerFactory entityManagerFactory;

	public RespostaService(EntityManagerFactory emf,RespostaDao empresaDao) {
		this.empresaDao=empresaDao;
		this.entityManagerFactory=emf;
	}
	
	public List<Resposta> list() {

		return empresaDao.list();
	}
	
	public void  save(Resposta resposta) {

		empresaDao.persist(resposta);
	}
	
}
