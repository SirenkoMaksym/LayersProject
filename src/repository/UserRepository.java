/*
 * created by ьфч$
 */


package repository;


import model.Role;
import model.User;
import util.MyArrayList;
import util.MyList;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository {
    private final MyList<User> users;
    // объект для генерации последовательных и уникальных id
    private final AtomicInteger currentId = new AtomicInteger(1);

    public UserRepository() {
        this.users = new MyArrayList<>();
        init();
    }


    private void init() {
        User user = new User(currentId.getAndIncrement(), "test@email.net", "qwerty!Q1");
        User user1 = new User(currentId.getAndIncrement(), "test1@email.net", "qwerty!Q1");
        User user2 = new User(currentId.getAndIncrement(), "test2@email.net", "qwerty!Q1");
        User user3 = new User(currentId.getAndIncrement(), "test3@email.net", "qwerty!Q1");
        User user4 = new User(currentId.getAndIncrement(), "test4@email.net", "qwerty!Q1");
        user.setRole(Role.ADMIN);

        users.addAll(user, user1, user2, user3, user4);
    }


    public MyList<User> getAllUsers() {
        return users;
    }


    public boolean isUserEmailExist(String email) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) return true;
        }
        return false;
    }

    public User createUser(String email, String password) {
        User user = new User(currentId.getAndIncrement(), email, password);
        if (user.getEmail() == null || user.getPassword() == null) return null;
        users.add(user);
        return user;
    }


}

