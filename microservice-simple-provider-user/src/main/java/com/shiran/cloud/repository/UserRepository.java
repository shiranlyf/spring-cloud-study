package com.shiran.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shiran.cloud.entity.User;

/**
 *  继承类JpaRepository<T, ID>的泛型为  java bean 和 对应的主键id的类型
 *  @Repository注解标识这个接口是一个Dao接口
 *  @author shiran
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
