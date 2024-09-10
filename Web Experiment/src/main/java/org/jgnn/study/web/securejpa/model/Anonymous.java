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
@Table(name = "anonymous")
public class Anonymous {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private long id;
	
	@Column(name = "sexo")
	private String sexo ; //SET('F', 'M');
	
	@Column(name = "idade")
	private String idade  ;
	
	@Column(name = "estadocivil")
	private String estadocivil  ; //SET('casado(a)', 'solteiro(a)')
	
	@Column(name = "escolaridade")
	private String escolaridade  ;
	
	@Column(name = "renda")
	private String renda  ;
	
	@Column(name = "sessn")
    private String sessn ;//guarda session
	
	private boolean anchordefined;
	
	//@OneToMany(mappedBy="anonymous")
    //private Set<AnchorItem> anchor;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anonymous other = (Anonymous) obj;
		if (id != other.id)
			return false;
		if (sessn == null) {
			if (other.sessn != null)
				return false;
		} else if (!sessn.contentEquals(other.sessn))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.contentEquals(other.sexo))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((sessn == null) ? 0 : sessn.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		return result;
	}
}