package com.zeecoder.kidsart.repository;

import com.zeecoder.kidsart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User, String> {

}
