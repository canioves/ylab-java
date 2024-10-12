package App;

import App.Menu.Context.HabitApp;

public class Main {
    public static void main(String[] args) {
        HabitApp habitApp = new HabitApp();

        while (true) {
            habitApp.request();
        }
    }
}
