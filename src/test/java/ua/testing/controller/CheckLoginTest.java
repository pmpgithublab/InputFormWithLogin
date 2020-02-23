/*
 * @(#)CheckLoginTest.java     1.00 2020/02/20
 *
 * This software is free for use.
 */


package ua.testing.controller;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.testing.controller.services.*;

import static org.junit.Assert.*;


/**
 * Tests user logins.
 *
 * @author Firstname Lastname
 * @version 1.00 20 Feb 2020
 */
public class CheckLoginTest {

    public ExpectedException expectedException = ExpectedException.none();

    @Test(expected = ExceptionSuchLoginExists.class)
    public void checkIncorrectLogins() throws ExceptionSuchLoginExists {
        expectedException.expect(ExceptionSuchLoginExists.class);
        CheckLogin.first.checkLogin("bob123");
    }

}