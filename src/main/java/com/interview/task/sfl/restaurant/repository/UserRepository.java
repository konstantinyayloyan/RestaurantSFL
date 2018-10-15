package com.interview.task.sfl.restaurant.repository;

import com.interview.task.sfl.restaurant.model.User;
import com.interview.task.sfl.restaurant.model.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    List<User> findUserByUserType(UserType userType);
}
