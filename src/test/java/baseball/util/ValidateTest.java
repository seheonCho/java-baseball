package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

class ValidateTest {

    private InputStream inputStream;

    private static InputStream generateInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("3자리인지 확인하는 기능")
    @Test
    void isRuleDigit_success() {
        String input = "abc";

        assertThat(input.length()).isEqualTo(GameRule.NUMBER_OF_NUMBERS);
        assertThat(Validate.isRuleDigit(input)).isTrue();
    }

    @DisplayName("3자리가 아닌것을 확인하는 기능")
    @Test
    void isRuleDigit_fail() {
        String input = "abcdef";

        assertThat(input.length()).isNotEqualTo(GameRule.NUMBER_OF_NUMBERS);
        assertThat(Validate.isRuleDigit(input)).isFalse();
    }

    @DisplayName("서로 다른숫자인지 확인하는 기능")
    @Test
    void isDifferentDigits_success() {
        String input = "123";

        assertThat(Validate.isDifferentDigits(input)).isTrue();
    }

    @DisplayName("서로 다른숫자인지 확인하는 기능")
    @Test
    void isDifferentDigits_fail() {
        String input = "121";

        assertThat(Validate.isDifferentDigits(input)).isFalse();
    }

    @DisplayName("서로 다른숫자인지 확인하는 기능")
    @Test
    void isDifferentDigits_fail_2() {
        String input = "112";

        assertThat(Validate.isDifferentDigits(input)).isFalse();
    }

    @DisplayName("0이 포함되지 않았는지 확인하는 기능")
    @Test
    void isNotContainZero_success() {
        String input = "114";
        assertThat(Validate.isNotContainZero(input)).isTrue();
    }

    @DisplayName("0이 포함되지 않았는지 확인하는 기능")
    @Test
    void isNotContainZero_fail() {
        String input = "120";
        assertThat(Validate.isNotContainZero(input)).isFalse();
    }

    @DisplayName("게임 종료시 1을 입력받은 경우 게임 재시작하고 2를 입력받은 경우 프로그램 종료")
    @Test
    void isAcceptAbleEndGame_success() {
        String userInput = "1";

        assertThat(Validate.isAcceptAbleEndGame(userInput)).isTrue();

        String secondUserInput = "2";

        assertThat(Validate.isAcceptAbleEndGame(secondUserInput)).isTrue();
    }

    @DisplayName("게임 종료시 1을 입력받은 경우 게임 재시작하고 2를 입력받은 경우 프로그램 종료")
    @Test
    void isAcceptAbleEndGame_fail() {
        String userInput = "3";

        assertThat(Validate.isAcceptAbleEndGame(userInput)).isFalse();
    }

    @DisplayName("게임 종료시 1을 입력받은 경우 게임 재시작하고 2를 입력받은 경우 프로그램 종료")
    @Test
    void isReStartGame_success() {
        String userInput = "1";

        assertThat(Validate.isReStartGame(userInput)).isTrue();
    }

    @DisplayName("게임 종료시 1을 입력받은 경우 게임 재시작하고 2를 입력받은 경우 프로그램 종료")
    @Test
    void isReStartGame_fail() {
        String userInput = "2";

        assertThat(Validate.isReStartGame(userInput)).isFalse();
    }

    @DisplayName("입력 검증 기능에 부합하지 않은 입력시 예외 발생")
    @Test
    void 사용자_입력_1도아니고_2도아니면_예외를_확인하는_테스트() {
        String theInput = "3";
        inputStream = generateInput(theInput);
        System.setIn(inputStream);

        assertThatThrownBy(() -> Validate.isAcceptAbleEndGame(theInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

}