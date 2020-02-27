/*
 * @(#)ExceptionSuchLoginExist.java     1.00 2020/02/20
 *
 * This software is free for use.
 */


package ua.testing.controller.services;


/**
 * An Exception class using during user login check.
 *
 * @author Firstname Lastname
 * @version 1.00 20 Feb 2020
 */
public class SuchLoginExistsException extends Throwable {
    String login;

    public SuchLoginExistsException(String message, String login) {
        super(message);
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
