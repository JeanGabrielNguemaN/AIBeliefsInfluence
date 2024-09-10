package org.jgnn.study.web.securejpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prediction")
public class Prediction {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private long id;
	
	@ManyToOne
    @JoinColumn(name = "newsid", nullable = false, referencedColumnName = "id")
    private News news;
	
	@ManyToOne
    @JoinColumn(name = "aimodelid", nullable = false, referencedColumnName = "id")
    private AIModel aimodel;
    
    private boolean res;
    private int acc;
}