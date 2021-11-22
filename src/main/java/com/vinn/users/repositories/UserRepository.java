package com.vinn.users.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vinn.users.entities.Profile;
import com.vinn.users.entities.User;

@Repository 
public interface UserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findByUsername(String username);
	
	public Optional<User> findByUsernameAndPassword(String username, String password);
	
	/*
	 * Esto no es SQL
	 * Es JPQL
	 * 
	 * */
	@Query("SELECT u.username FROM User u")
	public List<String> findUsernames();

	
}
