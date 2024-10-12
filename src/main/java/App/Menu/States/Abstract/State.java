package App.Menu.States.Abstract;

import App.Menu.Context.HabitApp;

public abstract class State {
    protected HabitApp context;

    protected State(HabitApp context) {
        this.context = context;
    }

    public abstract void handle();
}
