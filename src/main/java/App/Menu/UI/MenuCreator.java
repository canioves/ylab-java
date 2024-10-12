package App.Menu.UI;

import App.Menu.UI.Elements.InputField;
import App.Menu.UI.Elements.NumberOption;
import App.Menu.UI.Elements.TrueFalseOption;

import java.util.*;

public class MenuCreator {
    private LinkedHashMap<Integer, NumberOption> options;
    private LinkedHashMap<String, InputField> inputFields;
    private LinkedHashMap<String, TrueFalseOption> trueFalseOptions;
    private Scanner scan;


    public MenuCreator() {
        this.options = new LinkedHashMap<>();
        this.inputFields = new LinkedHashMap<>();
        this.trueFalseOptions = new LinkedHashMap<>();
        this.scan = new Scanner(System.in);
    }


    public void addNumberOption(NumberOption numberOption) {
        this.options.put(numberOption.getKey(), numberOption);
    }


    public int getOptionFromConsole() {
        int choose;
        while (true) {
            if (scan.hasNextInt()) {
                choose = scan.nextInt();
                if (options.containsKey(choose)) return choose;
            }
        }
    }


    public void renderAllOptions() {
        options.forEach((_, v) -> v.render());
    }


    public void addInputField(InputField inputField) {
        this.inputFields.put(inputField.getKey(), inputField);
    }


    private void renderInputField(String key) {
        inputFields.get(key).render();
    }


    private void setInputFieldValue(String key) {
        String value = scan.nextLine();
        InputField inputField = inputFields.get(key);
        if (inputField == null) {
            throw new NoSuchElementException("InputField с ключом " + key + " не существует");
        }
        inputField.setValue(value);
    }

    public String getInputFieldValue(String key) {
        return inputFields.get(key).getValue();
    }

    public void processAllInputFields() {
        inputFields.forEach((k, v) -> {
            this.renderInputField(k);
            this.setInputFieldValue(k);
        });
    }

    public void addTrueFalseOption(TrueFalseOption tfOption) {
        this.trueFalseOptions.put(tfOption.getKey(), tfOption);
    }

    public void setTrueFalseOptionValue(String key) {
        String value = scan.nextLine();
        TrueFalseOption tfOption = trueFalseOptions.get(key);
        if (tfOption == null) {
            throw new NoSuchElementException("tfOption с ключом " + key + " не существует");
        }
        tfOption.setValue(value);
    }

    public boolean getTrueFalseOptionValue(String key) {
        return this.trueFalseOptions.get(key).getValue();
    }

    public void renderTrueFalseOption(String key) {
        trueFalseOptions.get(key).render();
    }
}
