package com.customer.order.generateOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.order.generateOrder.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
