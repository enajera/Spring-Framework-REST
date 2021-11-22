package com.vinn.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.vinn.users.repositories.RoleRepository;
import com.vinn.users.repositories.UserInRoleRepository;
import com.vinn.users.entities.Role;
import com.vinn.users.entities.User;

@Service
public class RolService {

	@Autowired
	private RoleRepository repository;
	
	@Autowired
	private UserInRoleRepository userInRoleRepository;
	
	public List<User> getUsersByRole(String roleName){
		return userInRoleRepository.findUsersByRoleName(roleName);
	}

	public List<Role> getRoles() {
		return repository.findAll();
	}

	public Role createRole(Role role) {
		return repository.save(role);
	}

	public Role updateRole(Integer roleId, Role role) {
		Optional<Role> result = repository.findById(roleId);
		if (result.isPresent()) {
			return repository.save(role);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id $d doesn't exists", roleId));
		}
	}

	public void deleteRole(Integer roleId) {
		Optional<Role> result = repository.findById(roleId);
		if (result.isPresent()) {
			repository.delete(result.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id $d doesn't exists", roleId));
		}
	}

}
