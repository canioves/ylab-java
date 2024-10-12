package App.Menu.UI.Elements;

import App.Menu.UI.Interfaces.Element;

public class InputField implements Element {
    private String key;
    private String description;
    private String value;

    public InputField(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void render() {
        System.out.println(description);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
