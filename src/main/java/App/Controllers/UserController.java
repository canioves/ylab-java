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

        System.out.printf("Пользователь %s успешно зарегестрирован%n", userName);

        return newUser;
    }

    public User login(String email, String password) {
        User existingUser = this.userStorage.get(email);
        if (existingUser == null) throw new NoSuchElementException("Пользователь не существует");
        if (!password.contentEquals(existingUser.getPassword()))
            throw new IllegalArgumentException("Неверные данные для входа");

        System.out.println("Вход выполнен");
        return existingUser;
    }


    public User updateUserCredentials(String oldEmail, String newUserName, String newEmail, String newPassword) {
        User newUser = new User(newUserName, newEmail, newPassword);

        if (!oldEmail.contentEquals(newEmail)) {
            this.userStorage.remove(oldEmail);
        }

        this.userStorage.put(newEmail, newUser);
        return newUser;
    }

    public void deleteUser(String email) {
        this.userStorage.remove(email);
    }

    public void addTestUser() {
        User testUser = new User("test", "test@mail.com", "qwerty");
        this.userStorage.put("test@mail.com", testUser);
    }


}
