package com.geekdroid.service;

import com.geekdroid.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by james.li on 2017/3/2.
 */

@Component
public interface IUserService extends JpaRepository<User,Integer> {

    User findByUserId(String userId);

    @Query("UPDATE User u SET u.nickName = :nickName, u.description = :description WHERE u.userId = :userId")
    @Modifying
    @Transactional
    void updateUserInfo(@Param("userId") String userId, @Param("nickName") String nickName, @Param("description") String description);
}
