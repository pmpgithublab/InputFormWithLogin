/*
 * @(#)ReadNote.java     1.00 2020/02/11
 *
 * This software is free for use.
 */
package ua.testing.controller.services;

import ua.testing.model.entity.Address;
import ua.testing.model.entity.Groups;
import ua.testing.model.entity.NotebookNote;
import ua.testing.model.Model;
import ua.testing.view.*;

import java.util.HashSet;
import java.util.Scanner;


/**
 * Class for input Note data.
 *
 * @author Firstname Lastname
 * @version 1.00 20 Feb 2020
 */
public class ReadNote {
    Model model;
    View view;
    Scanner scanner = new Scanner(System.in);

    public ReadNote(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void readNewNoteFromScanner() {
        String login;
        while (true) {
            login = getScannerInputWithRegex(view.ASK_NICKNAME, view.REGEX_NICKNAME_CHECK_OUT);
            try {
                CheckLogin.first.checkLogin(login);
                break;
            } catch (ExceptionSuchLoginExists e) {
                View.showMessage(View.concatenatingStrings(view.EXCEPTION_SUCH_LOGIN_EXISTS, View.SPACE_SIGN, login));
            }
        }
        model.addNote(new NotebookNote(getScannerInputWithRegex(view.ASK_FIRST_NAME, view.REGEX_FIRST_NAME_CHECK_OUT),
                getScannerInputWithRegex(view.ASK_MIDDLE_NAME, view.REGEX_MIDDLE_NAME_CHECK_OUT),
                getScannerInputWithRegex(view.ASK_LAST_NAME, view.REGEX_LAST_NAME_CHECK_OUT),
                login,
                getScannerInputWithRegex(view.ASK_COMMENT, view.REGEX_COMMENT_CHECK_OUT),
                createGroupList(getScannerInputWithRegex(View.concatenatingStrings(view.ASK_USER_GROUPS, Groups.FAMILY.getList()), Groups.FAMILY.getRegexNames())),
                getScannerInputWithRegex(view.ASK_HOME_PHONE_NUMBER, view.REGEX_HOME_PHONE_CHECK_OUT),
                getScannerInputWithRegex(view.ASK_CELL_PHONE_NUMBER, view.REGEX_CELL_PHONE_CHECK_OUT),
                getScannerInputWithRegex(view.ASK_CELL_PHONE2_NUMBER, view.REGEX_CELL_PHONE2_CHECK_OUT),  // there is a problem: scanner does not read an empty string
                getScannerInputWithRegex(view.ASK_EMAIL, view.REGEX_EMAIL_CHECK_OUT),  //"sdgzf@lkdsfsj.df", <- there is a problem: do not recognize any email
                getScannerInputWithRegex(view.ASK_SKYPE, view.REGEX_SKYPE_CHECK_OUT),
                new Address(getScannerInputWithRegex(view.ASK_INDEX, view.REGEX_INDEX_CHECK_OUT),
                        getScannerInputWithRegex(view.ASK_CITY, view.REGEX_CITY_CHECK_OUT),
                        getScannerInputWithRegex(view.ASK_STREET, view.REGEX_STREET_CHECK_OUT),
                        getScannerInputWithRegex(view.ASK_BUILDING, view.REGEX_BUILDING_CHECK_OUT),
                        getScannerInputWithRegex(view.ASK_FLAT, view.REGEX_FLAT_CHECK_OUT))
        ));
        View.showMessage(view.SUCCESSFULLY_ADDED);
    }

    private String getScannerInputWithRegex(String messageForUser, String regexForReading) {
        View.showMessage(messageForUser);
        while (!scanner.hasNext(regexForReading)) {
            View.showMessage(view.WRONG_INPUT);
            scanner.next();
        }
        return scanner.next();
    }

    public HashSet<Groups> createGroupList(String user_groups) {
        String regexForGroups = view.REGEX_USER_GROUPS;
        HashSet<Groups> result = new HashSet<>();
        for (Groups group : Groups.values()) {
            if (user_groups.matches(View.concatenatingStrings(regexForGroups, group.toString(), regexForGroups))) {
                result.add(group);
            }
            if (user_groups.matches(View.concatenatingStrings(regexForGroups, group.toString().toLowerCase(), regexForGroups))) {
                result.add(group);
            }
        }
        return result;
    }

}
