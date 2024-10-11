package App.Menu.Concrete.ProfileMenuStates;

import App.Menu.Abstract.State;
import App.Menu.HabitApp;
import App.Models.User;

public class ChangeProfileState extends State {
    ChangeProfileState(HabitApp context) {
        super(context);
    }

    @Override
    public void handle() {
        User changedUser = context.getUser();
        System.out.println("Если изменения не требуются, нажмите Enter...");
        System.out.println("Введите новый логин: ");
        System.out.println("Введите новый емайл: ");
        System.out.println("Введите новый пароль: ");

        System.out.println("Для подтверждения изменений, введите текущий пароль: ");

    }
}
