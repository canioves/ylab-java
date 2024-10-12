package App.Menu.States.Concrete.LoginMenuStates;

import App.Menu.States.Abstract.State;
import App.Menu.States.Concrete.MainMenuStates.MainMenuState;
import App.Menu.Context.HabitApp;
import App.Menu.UI.Elements.InputField;
import App.Menu.UI.MenuCreator;


public class RegisterState extends State {

    public RegisterState(HabitApp context) {
        super(context);
    }

    @Override
    public void handle() {
        MenuCreator registerForm = new MenuCreator();
        registerForm.addInputField(new InputField("userName", "Имя пользователя: "));
        registerForm.addInputField(new InputField("email","Email пользователя: "));
        registerForm.addInputField(new InputField("password","Пароль пользователя: "));

        registerForm.processAllInputFields();

        String userName = registerForm.getInputFieldValue("userName");
        String email = registerForm.getInputFieldValue("email");
        String password = registerForm.getInputFieldValue("password");

        try {
            this.context.registerUser(userName, email, password);
            this.context.changeState(new MainMenuState(context));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            this.context.changeState(new InitialState(context));
        }

    }
}