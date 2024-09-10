package org.jgnn.study.web.securejpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stepquestion")
public class Stepquestion {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private long id;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "step_id", nullable = false, referencedColumnName = "id")
    private Step step;
	
	private String question;
	
	private int questionorder;
}