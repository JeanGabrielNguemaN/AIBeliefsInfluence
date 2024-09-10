/*
 * Copyright 2024 Jean Gabriel Nguema Ngomo.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developer.sun.com/berkeley_license.html
 */

package org.jgnn.study.web.securejpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resposta")
public class Resposta implements Serializable, Comparable<Resposta> {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conteudo;
  
    public Resposta() {
    	
    }

    public Resposta(Long id, String nome) {
    	this(nome);
    	this.id=id; 
    }
    
    public Resposta(String nome) {
    
        this.conteudo=nome;
    }

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int compareTo(Resposta o) {
		// TODO Auto-generated method stub
		return this.conteudo.compareTo(o.getConteudo());
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
}