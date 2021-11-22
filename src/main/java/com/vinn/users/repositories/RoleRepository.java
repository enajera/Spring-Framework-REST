package com.vinn.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vinn.users.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
