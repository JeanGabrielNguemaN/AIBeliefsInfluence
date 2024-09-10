package org.jgnn.study.web.securejpa.model.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Participant {

	private String nome;
	
	private String julgamento;
	
}
