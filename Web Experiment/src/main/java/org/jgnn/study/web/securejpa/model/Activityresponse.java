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
@Table(name = "activityresponse")
public class Activityresponse {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private long id;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "activity_id", nullable = false, referencedColumnName = "id")
    private Activity activity;
	
	@ManyToOne
    @JoinColumn(name = "question_id", nullable = false, referencedColumnName = "id")
    private Stepquestion question;
	
	private String response;
}