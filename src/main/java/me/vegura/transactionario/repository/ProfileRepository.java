package me.vegura.transactionario.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import me.vegura.transactionario.domain.dbmodel.Profile;

public interface ProfileRepository extends JpaRepository<Profile, UUID>{
	@Query(value = "SELECT * "
			+ "FROM profiles "
			+ "WHERE upper(concat(profiles.first_name, ' ', profiles.last_name)) LIKE concat('%', upper(:fullnamesnippet), '%')",
			nativeQuery = true
	)
	Page<Profile> findByFullName(@Param("fullnamesnippet") String fullNameSnippet, Pageable pagable);
	
}
