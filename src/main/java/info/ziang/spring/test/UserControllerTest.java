package info.ziang.spring.test;

import info.ziang.spring.controller.UserController;
import info.ziang.spring.di.BeanFactory;

public class UserControllerTest {

    public static void main(String[] args) {
        UserController userController = BeanFactory.getBean(UserController.class);
        userController.save();
    }
}
