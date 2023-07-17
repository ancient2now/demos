package com.akikun.demo.spring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 李俊秋(龙泽)
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
