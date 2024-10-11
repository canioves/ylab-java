package App.Menu.UI;

import java.util.HashMap;
import java.util.Scanner;

public class MenuCreator {
    private HashMap<Integer, String> options;
    private Scanner scan;

    public MenuCreator() {
        this.options = new HashMap<>();
        this.scan = new Scanner(System.in);
    }

    public void addOption(int optionNumber, String description) {
        this.options.put(optionNumber, description);
    }

    public void render() {
        this.options.forEach((key, value ) -> System.out.printf("%d. %s%n", key, value));
    }

    public int getInput() {
        int input;

        while (true) {
            if (scan.hasNextInt()) {
                input = scan.nextInt();
                if (this.options.containsKey(input)) return input;
                else System.out.println("Неверный выбор");
            } else {
                System.out.println("Введите номер опции");
                scan.next();
            }
        }
    }
}
