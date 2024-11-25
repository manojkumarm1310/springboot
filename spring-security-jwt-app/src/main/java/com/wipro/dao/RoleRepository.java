package com.wipro.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import com.wipro.model.Role;


public interface RoleRepository extends JpaRepository<Role,Long> {
}
