package com.shana.house.service;

import com.shana.house.mapper.UserMapper;
import com.shana.house.model.User;
import com.shana.house.qv.UserP;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author xiana
 * @create 2019/11/19
 * @since 1.0.0
 */
@Service
@Transactional
public class FrontUserServiceImp implements IFrontUserService{
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public User Login(User user) {
        return userMapper.selectByAccountAndPassword(user.getAccount(),user.getPassword());
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public String register(UserP user) {
        String account=user.getAccount();
        String mobilephone=user.getMobilephone();
        String phoneCode=user.getPhonecode();
        String phonecode= (String) redisTemplate.opsForValue().get(mobilephone);
        if(phonecode!=null){
            if(phoneCode.equals(phonecode)){
                if(userMapper.selectByAccount(account)!=null){
                    //账号已存在
                    return "1";
                }else{
                    //注册成功
                    userMapper.insertUser(user);
                    return"2";
                }
            }else{
                //验证码错误
                return "3";
            }
        }
        //验证码已失效
        return "0";
    }

    @Override
    public User sekectByAccount(String account) {
        return userMapper.selectByAccount(account);
    }

    @Override
    public void changeAge(String account, Date birthday, Integer age) {
        userMapper.changeAge(account,birthday,age);
    }

    @Override
    public void changeSxe(String account, String sex) {
        userMapper.changeSxe(account,sex);
    }

    @Override
    public void changeEmail(String account, String email) {
        userMapper.changeEmail(account,email);
    }

    @Override
    public void changePhone(String account, String mobilephone) {
        userMapper.changePhone(account,mobilephone);
    }

    @Override
    public void changeImg(String account, String headimg) {
        userMapper.changeImg(account,headimg);
    }

}

