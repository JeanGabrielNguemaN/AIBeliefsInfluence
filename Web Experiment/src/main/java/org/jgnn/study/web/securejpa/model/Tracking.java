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
@Table(name = "tracking")
public class Tracking {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private long id;
	
	@OneToOne(optional = false)
    @JoinColumn(name = "userid", nullable = false, referencedColumnName = "id")
    private Anonymous user;
	
	@OneToOne
    @JoinColumn(name = "activity_id", nullable = false, referencedColumnName = "id")
    private Activity activity;
	
	private int completedactivities;
	
	//indica se o experimento foi completado
	private boolean isover;
}