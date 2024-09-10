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
@Table(name = "aimodel")
public class AIModel {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id")
    private long id;
	
    @Column(name = "model")
    private String model;

}