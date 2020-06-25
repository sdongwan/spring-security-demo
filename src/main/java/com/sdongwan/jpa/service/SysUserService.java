package com.sdongwan.jpa.service;

import com.sdongwan.jpa.dao.SysUserRepository;
import com.sdongwan.jpa.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    public SysUser saveOne(SysUser sysUser) {
        return sysUserRepository.save(sysUser);
    }


    public SysUser listOne(String userId) {
        int id = Integer.parseInt(userId);
        return sysUserRepository.findByUserId(id);
    }

    public List<SysUser> listSameAccount(String account,String pwd) {
        return sysUserRepository.findByUsernameAndPassword(account,pwd);
    }

    public List<SysUser> listByQuery(String account,String pwd) {
        return sysUserRepository.findBySelfQuery(account,pwd);
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
}
