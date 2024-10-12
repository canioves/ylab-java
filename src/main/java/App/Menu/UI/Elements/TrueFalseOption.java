package App.Menu.UI.Elements;

import App.Menu.UI.Interfaces.Element;

public class TrueFalseOption implements Element {
    private String key;
    private String trueValue;
    private String falseValue;
    private String description;
    private boolean value;

    public TrueFalseOption(String key, String description, String trueValue, String falseValue) {
        this.description = description;
        this.key = key;
        this.trueValue = trueValue;
        this.falseValue = falseValue;
    }

    public void setValue(String value) {
        if (!value.contentEquals(trueValue) && !value.contentEquals(falseValue)) {
            throw new IllegalArgumentException("Неверный ввод...");
        }
        this.value = value.contentEquals(trueValue);
    }

    public boolean getValue() {
        return this.value;
    }

    public String getKey() {
        return key;
    }

    @Override
    public void render() {
        String options = String.format("%s/%s", trueValue, falseValue);
        System.out.println(description + " " + options);
    }
}
