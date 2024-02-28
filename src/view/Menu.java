/*
 * created by max$
 */


package view;

import model.User;
import service.UserService;
import util.MyList;

import java.util.Scanner;

public class Menu {

    private final UserService service;

    private final Scanner scanner = new Scanner(System.in);

    public Menu(UserService service) {
        this.service = service;
    }

    public void run() {
        showMenu();
    }

    private void showMenu() {
        while (true) {
            System.out.println("Добро пожаловать в интернет магазин Мега!");
            System.out.println("1. Меню пользователей");
            System.out.println("2. Меню заказов");
            System.out.println("3. Меню администратора");
            System.out.println("0. Выход");
            System.out.println("\nСделайте выбор пункта");
            int input = scanner.nextInt();
            scanner.nextLine();

            if (input == 0) {
                System.out.println("до свидания!");
                System.exit(0);
                //break;
            }
            showSubMenu(input);
        }
    }

    private void showSubMenu(int input) {
        switch (input) {
            case 1:
                showUserMenu();
                break;
            case 2:
                showOrderMenu();
                break;
            case 3:
                showAdminMenu();
                break;
            default:
                System.out.println("Ваш выбор не корректен");
                waitRead();
        }

    }

    private void showOrderMenu() {
        System.out.println("Меню заказов");
        //TODO
    }

    private void showAdminMenu() {
        System.out.println("Меню Администратора");
        //TODO
    }

    private void showUserMenu() {
        while (true) {
            System.out.println("Меню пользователя");
            System.out.println("1. Авторизация в системе");
            System.out.println("2. Регистрация");
            System.out.println("3. Logout");
            System.out.println("4. Список всех пользователей");
            System.out.println("0. Выход");

            System.out.println("\nСделайте выбор пункта");
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == 0) break;
            handleUserMenuChoice(input);
        }
    }

    private void handleUserMenuChoice(int input) {
        switch (input){
            case 1:
                /*
                User user1 = service.autorise("2333","4444");
                if (user1 == null){
                    System.out.println("все плохо");
                }else{
                    System.out.println("Вы успешно зарегистрировались");
                }
                waitRead();

                 */

                service.autorise("test@email.net", "gsdgds");
                if(service.getActiveUser() == null){
                    System.out.println("В системе никто не авторизирован!");
                    waitRead();
                }else {
                    System.out.println("В системе есть авторизованный пользователь!");
                }
                break;
            case 2:
                System.out.println("Введите Ваш е-маил: ");
                String email = scanner.nextLine();

                System.out.println("Введи Ваш пароль: ");
                String password = scanner.nextLine();

                User registerUser = service.registerUser(email, password);
                if (registerUser == null){
                    System.out.println("Вы ввели некорректный емаил или пароль!");
                }else {
                    System.out.println("Вы успешно зарегистрировались в системе!");
                    System.out.println("Для начала работы пройдите авторизацию!");
                }
                waitRead();
                break;
            case 3:
                break;
            case 4:
                MyList<User> userList = service.getAllUsers();
                for(User user: userList.toArray()){
                    System.out.println(user);
                }
                waitRead();
                break;
            default:
                System.out.println("\n Неверный ввод");
                waitRead();
        }
    }

    private void waitRead() {
        System.out.println("\nДля продолжения нажмите Enter...");
        scanner.nextLine();
    }
}
