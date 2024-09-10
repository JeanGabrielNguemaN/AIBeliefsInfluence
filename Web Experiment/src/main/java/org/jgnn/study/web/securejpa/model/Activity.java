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
@Table(name = "activity")
public class Activity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private long id;
	
	@ManyToOne
    @JoinColumn(name = "news_id", nullable = false, referencedColumnName = "id")
    private News news;
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private Anonymous user;
	
	@ManyToOne
	@JoinColumn(name = "currentStep_id", nullable = false, referencedColumnName = "id")
    private Step step;
    
    private boolean isCompleted;
    
}