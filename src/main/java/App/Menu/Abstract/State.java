package App.Menu.Abstract;

import App.Menu.HabitApp;

public abstract class State {
    protected HabitApp context;

    protected State(HabitApp context) {
        this.context = context;
    }

    public abstract void handle();
}
