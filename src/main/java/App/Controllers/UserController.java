package App.Controllers;

import App.Models.User;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class UserController {
    private HashMap<String, User> userStorage;

    public UserController() {
        this.userStorage = new HashMap<>();
    }

    public User register(String userName, String email, String password) {
        if (userStorage.containsKey(email)) {
            throw new IllegalArgumentException("Пользователь уже зарегестрирован");
        }
        User newUser = new User(userName, email, password);
        userStorage.put(email, newUser);

        System.out.printf("Поьзователь %s успешно зарегестрирован%n", userName);

        return newUser;
    }

    public User login(String email, String password) {
        User existingUser = this.userStorage.get(email);
        if (existingUser == null) throw new NoSuchElementException("Пользователь не существует");
        if (!password.contentEquals(existingUser.getPassword()))
            throw new IllegalArgumentException("Неправильный емайл или пароль");

        System.out.println("Вход выполнен");
        return existingUser;
    }

    public void addUser(User user) {
        userStorage.put(user.getEmail(), user);
    }
}
