package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private String userInput;

    public Input() {}

    public void setUserInput(String userInput) {
        this.userInput = readUserInput();
    }

    public String readUserInput() {
        return Console.readLine();
    }

    public String getUserInput() {
        return userInput;
    }
}
