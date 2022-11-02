package org.example;

import java.util.ArrayList;
import java.util.Iterator;

public class User implements Iterable {

    private String login;

    private String password;
    private ArrayList<User> users;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public Iterator<User> iterator() {
        return new UserIterator<User>(users);
    }

}
