







/*
 * @(#)CheckLogin.java     1.00 2020/02/20
 *
 * This software is free for use.
 */


package ua.testing.controller.services;


import ua.testing.view.View;

/**
 * Class for test user login.
 *
 * @author Firstname Lastname
 * @version 1.00 20 Feb 2020
 */
public enum CheckLogin {
    first("John", "a12345678"),
    second("Bob", "b12345678"),
    third("Jay", "c12345678");

    String name;
    String nickname;

    CheckLogin(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public void checkLogin(String login) throws ExceptionSuchLoginExists {
        for (CheckLogin savedLogins : CheckLogin.values()) {
            if (savedLogins.nickname.equals(login)) {
                throw new ExceptionSuchLoginExists(login);
            }
        }
    }

}