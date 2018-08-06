package com.smart.dao.Imp;

import com.smart.dao.LoginDao;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImp implements LoginDao {
    @Override
    public String loginIn() {
        return "hello world2";
    }
}
