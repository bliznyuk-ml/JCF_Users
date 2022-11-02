package org.example;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();


        while (true) {
            System.out.println("Оберіть команду: \n 1. Додати нового користувача \n 2. Видалити існуючого користувача \n 3. Перевірити, чи існує користувач \n" +
                    " 4. Змінити логін існуючого користувача \n 5. Змінити пароль існуючого користувача");
            switch (scanner.nextInt()) {
                case 1:
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
                    break;

                case 2:
                    if (users.size() == 0) {
                        System.out.println("Не зареєстровано жодного користувача");
                        break;
                    } else {
                        System.out.println("Введіть логін, який треба видалити: ");
                        String login = scanner.next();
                        for (User user : users) {
                            if (user.getLogin().equals(login)) {
                                users.remove(user);
                                System.out.println("Користувача з логіном " + login + " видалено");
                                break;
                            } else {
                                System.out.println("Користувача з логіном " + login + " не знайдено");
                            }
                        }
                    }
                    break;

                case 3:
                    if (users.size() == 0) {
                        System.out.println("Не зареєстровано жодного користувача");
                        break;
                    } else {
                        System.out.println("Введіть логін, який треба видалити: ");
                        String login = scanner.next();
                        for (User user : users) {
                            if (user.getLogin().equals(login)) {
                                System.out.println("Користувача з логіном " + login + " існує у системі");
                                break;
                            } else {
                                System.out.println("Користувача з логіном " + login + " не знайдено");
                            }
                        }
                    }
                    break;

                case 4:
                    if (users.size() == 0) {
                        System.out.println("Не зареєстровано жодного користувача");
                        break;
                    } else {
                        System.out.println("Введіть логін, який треба змінити: ");
                        String login = scanner.next();
                        for (User user : users) {
                            if (user.getLogin().equals(login)) {
                                System.out.println("Введіть новий логін: ");
                                login = scanner.next();
                                user.setLogin(login);
                                System.out.println("Логін змінено на: " + login);
                            } else {
                                System.out.println("Користувача з логіном " + login + " не знайдено");
                            }
                        }
                    }
                    break;

                case 5:
                    if (users.size() == 0) {
                        System.out.println("Не зареєстровано жодного користувача");
                        break;
                    } else {
                        System.out.println("Введіть логін, пароль якого треба змінити: ");
                        String login = scanner.next();
                        for (User user : users) {
                            if (user.getLogin().equals(login)) {
                                System.out.println("Введіть новий пароль: ");
                                String password = scanner.next();
                                user.setPassword(password);
                                System.out.println("Пароль змінено!");
                            } else {
                                System.out.println("Користувача з логіном " + login + " не знайдено");
                            }
                        }
                    }
                    break;
            }
        }
    }
}
