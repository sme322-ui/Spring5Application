package com.example.spring5application;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("ALL")
public interface UserRepository extends JpaRepository<User1,Long> {
    List<User1> findByEmailOrName(String email, String name);

    @Query("select u from User u where u.name like %?1")
    User1 findByName(String name);

    @Query(value = "select * from user",nativeQuery = true)
    List<User1> findAllNative();

    @Modifying
    @Query("update user set email = :email where name=:name")
    Void updateUserEmailByName(@Param("name")String name,@Param("email")String email);


}
