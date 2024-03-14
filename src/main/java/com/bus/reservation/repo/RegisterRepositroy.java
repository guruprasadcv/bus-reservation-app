package com.bus.reservation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.reservation.entity.UserEntity;

public interface RegisterRepositroy  extends JpaRepository<UserEntity, Integer>{

	UserEntity findByuserName(String userName);

}
