package com.sdongwan.jpa.dao;

import com.sdongwan.jpa.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  @author: sdongwan
 *  @Date: 2019/12/6 下午 10:13
 *  @Description:
 */
public interface SysUserRepository extends JpaRepository<SysUser,Integer> {

    SysUser findByUserId(int userId);

    SysUser findByUsername(String username);

    List<SysUser> findByUsernameAndPassword(String username,String password);

    @Query(value ="select * from sys_user where username = ? and password = ?",nativeQuery = true)
    List<SysUser> findBySelfQuery(String username,String password);
}
