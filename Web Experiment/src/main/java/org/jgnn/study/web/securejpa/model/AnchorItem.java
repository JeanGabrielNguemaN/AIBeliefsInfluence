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
@Table(name = "anchor")
public class AnchorItem {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private long id;
	
	@ManyToOne
    @JoinColumn(name = "anonymousid", nullable = false, referencedColumnName = "id")
    private Anonymous anonymous  ;
	
	
	@ManyToOne
    @JoinColumn(name = "topicid", nullable = false, referencedColumnName = "id")
    private Topic topic  ;
	
	
	@Column(name = "response")
	private String response  ;


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnchorItem other = (AnchorItem) obj;
		if (anonymous == null) {
			if (other.anonymous != null)
				return false;
		} else if (!anonymous.equals(other.anonymous))
			return false;
		if (id != other.id)
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.contentEquals(other.response))
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		return true;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anonymous == null) ? 0 : anonymous.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((response == null) ? 0 : response.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		return result;
	}
	

}