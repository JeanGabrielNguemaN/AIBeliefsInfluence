package org.jgnn.study.web.securejpa.repository;



import java.util.Optional;

import org.jgnn.study.web.securejpa.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
    Role findByRole(String role);

	Optional<Role> findById(Long id);
    
}