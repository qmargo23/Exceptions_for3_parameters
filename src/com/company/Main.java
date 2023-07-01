package com.company;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //все верно
//        checkLoginAndPassword("login_2023", "password_2023", "password_2023");
        //логин неверный
         checkLoginAndPassword("It's my new login from past'", "password", "password");
        //пароль неверный
//        checkLoginAndPassword("login", "пароль", "password");
        //пароли не совпадают
//        checkLoginAndPassword("login", "password", "p@$$w0rd");
    }

    public static void checkLoginAndPassword(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Проверка проведена");
        }
    }

    private static void checkLogin(String login) throws WrongLoginException {
        Pattern p = Pattern.compile("^[a-z0-9_-]{1,20}$");
        if (!p.matcher(login).matches()) {
            throw new WrongLoginException("Логин \" " + login + "\" не подходит. " );
        }
    }

    private static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        Pattern p = Pattern.compile("^[a-z0-9_-]{1,20}$");
        if (!p.matcher(password).matches()) {
            throw new WrongPasswordException("Пароль \"" +password + "\" не подходит. " );
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}