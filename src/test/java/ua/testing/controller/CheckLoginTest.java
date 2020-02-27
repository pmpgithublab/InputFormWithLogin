/*
 * @(#)CheckLoginTest.java     1.00 2020/02/20
 *
 * This software is free for use.
 */


package ua.testing.controller;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.testing.controller.services.*;


/**
 * Tests user logins.
 *
 * @author Firstname Lastname
 * @version 1.00 20 Feb 2020
 */
public class CheckLoginTest {

    public ExpectedException expectedException = ExpectedException.none();

    @Test(expected = SuchLoginExistsException.class)
    public void checkIncorrectLogins() throws SuchLoginExistsException {
        expectedException.expect(SuchLoginExistsException.class);
        DBCheckLogin.first.checkLogin("","a12345678");
    }

}