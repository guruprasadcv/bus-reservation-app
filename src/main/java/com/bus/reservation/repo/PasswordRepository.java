package com.bus.reservation.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bus.reservation.entity.UserEntity;

public interface PasswordRepository extends JpaRepository<UserEntity, String> {
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update UserEntity set password=:password where userName=:username")
	int resetPassword(@Param("username") String username, @Param("password")String password);
}
