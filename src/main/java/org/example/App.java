package org.example;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();

        Command[] cmd = new Command[5];

        cmd[0] = new Command() {
            {
                command = "1";
            }

            @Override
            void command() {
                boolean isUser = true;
                while (isUser) {
                    boolean notUser = true;
                    System.out.println("Введіть логін: ");
                    String login = scanner.next();
                    for (User user : users) {
                        if (user.getLogin().equals(login)) {
                            System.err.println("Такий логін вже існує");
                            notUser = false;
                        }
                    }
                    if (notUser) {
                        System.out.println("Введіть пароль: ");
                        String password = scanner.next();
                        users.add(new User(login, password));
                        isUser = false;
                    }
                }
            }
        };

        cmd[1] = new Command() {
            {
                command = "2";
            }

            @Override
            void command() {
                if (users.size() == 0) {
                    System.out.println("Не зареєстровано жодного користувача");
                } else {
                    System.out.println("Введіть логін користувача, якого треба видалити: ");
                    String login = scanner.next();
                    User tmp = null;
                    for (User user : users) {
                        if (user.getLogin().equals(login)) {
                            tmp = user;
                            break;
                        }
                    }
                    if (tmp == null) {
                        System.out.println("Користувача з логіном " + login + " не знайдено");
                    }
                    if (tmp != null) {
                        users.remove(tmp);
                        System.out.println("Користувача з логіном " + login + " видалено");
                    }
                }
            }
        };

        cmd[2] = new Command() {
            {
                command = "3";
            }

            @Override
            void command() {
                if (users.size() == 0) {
                    System.out.println("Не зареєстровано жодного користувача");
                } else {
                    System.out.println("Введіть логін користувача, який треба знайти: ");
                    String login = scanner.next();
                    User tmp = null;
                    for (User user : users) {
                        if (user.getLogin().equals(login)) {
                            tmp = user;
                            break;
                        }
                    }
                    if (tmp == null) {
                        System.out.println("Користувача з логіном " + login + " не знайдено");
                    }
                    if (tmp != null) {
                        System.out.println("Користувач з логіном " + login + " існує у системі");
                    }
                }
            }
        };

        cmd[3] = new Command() {
            {
                command = "4";
            }

            @Override
            void command() {
                if (users.size() == 0) {
                    System.out.println("Не зареєстровано жодного користувача");
                } else {
                    System.out.println("Введіть логін користувача, який треба змінити: ");
                    String login = scanner.next();
                    User tmp = null;
                    for (User user : users) {
                        if (user.getLogin().equals(login)) {
                            tmp = user;
                            System.out.println("Введіть пароль");
                            String password = scanner.next();
                            if (password.equals(user.getPassword())) {
                                System.out.println("Введіть новий логін: ");
                                login = scanner.next();
                                user.setLogin(login);
                                System.out.println("Логін змінено на: " + login);
                            } else {
                                System.out.println("Невірний пароль");
                            }
                        }
                    }
                    if(tmp == null){
                        System.out.println("Користувача з логіном " + login + " не знайдено");
                    }
                }
            }
        };

        cmd[4] = new Command() {
            {
                command = "5";
            }

            @Override
            void command() {
                if (users.size() == 0) {
                    System.out.println("Не зареєстровано жодного користувача");
                } else {
                    System.out.println("Введіть логін користувача, пароль якого треба змінити: ");
                    String login = scanner.next();
                    User tmp = null;
                    for (User user : users) {
                        if (user.getLogin().equals(login)) {
                            tmp = user;
                            System.out.println("Введіть пароль");
                            String password = scanner.next();
                            if (password.equals(user.getPassword())) {
                                System.out.println("Введіть новий пароль: ");
                                password = scanner.next();
                                user.setPassword(password);
                                System.out.println("Пароль змінено!");
                            } else {
                                System.out.println("Невірний пароль!");
                            }
                        }
                    }
                    if(tmp == null){
                        System.out.println("Користувача з логіном " + login + " не знайдено");
                    }
                }
            }
        };

        while (true) {
            System.out.println("Оберіть команду: \n 1. Додати нового користувача \n 2. Видалити існуючого користувача \n 3. Перевірка наявності користувача \n" +
                    " 4. Змінити логін існуючого користувача \n 5. Змінити пароль існуючого користувача");
            String choose = scanner.next();
            for (Command c : cmd) {
                if (c.command.equals(choose)) {
                    c.command();
                }
            }
        }
    }
}
