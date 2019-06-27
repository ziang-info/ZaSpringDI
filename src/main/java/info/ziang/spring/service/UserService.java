package info.ziang.spring.service;

import info.ziang.spring.dao.ClassDao;
import info.ziang.spring.dao.UserDao;
import info.ziang.spring.di.Inject;

public class UserService {

    @Inject
    private UserDao userDao;

    @Inject
    private ClassDao classDao;

    public void save() {
        userDao.save();
        classDao.save();
    }

    public UserService() {
    }

}