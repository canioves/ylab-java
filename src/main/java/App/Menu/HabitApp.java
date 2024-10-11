package App.Menu;

import App.Controllers.UserController;
import App.Menu.Abstract.State;
import App.Menu.Concrete.LoginMenuStates.InitialState;
import App.Models.User;

public class HabitApp {
    private State state;
    public UserController userController;
    private User user;

    public HabitApp() {
        this.userController = new UserController();
        this.state = new InitialState(this);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void request() {
        this.state.handle();
    }
}
