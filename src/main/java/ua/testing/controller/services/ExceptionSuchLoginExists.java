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
public class ExceptionSuchLoginExists extends Throwable {
    public ExceptionSuchLoginExists(String message) {
        super(message);
    }
}
