/*
 * created by max$
 */


package service;


import model.User;
import repository.UserRepository;
import util.MyList;

public class UserService {

    private User activeUser;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MyList<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User createUser(String email, String password) {
        boolean isExist = userRepository.isUserEmailExist(email);
        if (isExist) {
            return null;
        }
        // Мне нужно провалидировать мой email и пароль
        User user = userRepository.createUser(email, password);
        return user;
    }

    public User registerUser(String email, String password) {
        if (email == null || password == null) {
            System.out.println("Пустой емаил или пароль");
            return null;
        }
        if (userRepository.isUserEmailExist(email)){
            System.out.println("Пользователь с таким емаил уже существует!");
            return null;
        }
        User user = userRepository.createUser(email,password);
        return user;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void autorise(String email, String password) {
       // User user = userRepository.getUserByEmail("test@email.net");
    }
}

