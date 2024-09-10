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
@Table(name = "news")
public class News {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id")
    private long id;
	
    @Column(name = "story")
    private String story;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		if (id != other.id)
			return false;
		if (story == null) {
			if (other.story != null)
				return false;
		} else if (!story.contentEquals(other.story))
			return false;
		
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((story == null) ? 0 : story.hashCode());
		return result;
	}
   
}