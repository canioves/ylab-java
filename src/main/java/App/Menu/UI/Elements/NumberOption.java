package App.Menu.UI.Elements;

import App.Menu.UI.Interfaces.Element;

public class NumberOption implements Element {
    private int key;
    private String description;

    public NumberOption(int key, String description) {
        this.key = key;
        this.description = description;
    }

    public int getKey() {
        return key;
    }

    public void render() {
        System.out.println(key + ". " + description);
    }
}
