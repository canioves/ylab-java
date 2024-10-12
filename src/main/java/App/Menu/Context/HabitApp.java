package App.Menu.Context;

import App.Controllers.UserController;
import App.Menu.States.Concrete.LoginMenuStates.InitialState;
import App.Menu.States.Abstract.State;
import App.Models.User;

public class HabitApp {
    private State state;
    private UserController userController;
    private User user;

    public HabitApp() {
        this.userController = new UserController();
        this.userController.addTestUser();
        this.state = new InitialState(this);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void request() {
        this.state.handle();
    }

    public void loginUser(String email, String password) {
        this.user = this.userController.login(email, password);
    }

    public void registerUser(String userName, String email, String password) {
        this.user = this.userController.register(userName, email, password);
    }

    public void updateUser(String newUserName, String newEmail, String newPassword) {
        String userName = newUserName.isEmpty() ? this.user.getUserName() : newUserName;
        String email = newEmail.isEmpty() ? this.user.getEmail() : newEmail;
        String password = newPassword.isEmpty() ? this.user.getPassword() : newPassword;
        String oldEmail = this.user.getEmail();
        this.user = this.userController.updateUserCredentials(oldEmail, userName, email, password);
    }

    public void deleteUser() {
        this.userController.deleteUser(this.user.getEmail());
        this.user = null;
    }
}
