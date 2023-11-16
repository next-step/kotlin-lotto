package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

class StringAddCalculatorParserTest {

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 빈 리스트를 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    fun emptyOrNull(text: String?) {
        assertThat(StringAddCalculatorParser.parse(text)).isEmpty()
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @Test
    fun oneNumber() {
        assertThat(StringAddCalculatorParser.parse("1"))
            .containsExactly(StringAddCalculatorNumber.of("1"))
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @Test
    fun twoNumbers() {
        assertThat(StringAddCalculatorParser.parse("1,2"))
            .containsExactly(
                StringAddCalculatorNumber.of("1"),
                StringAddCalculatorNumber.of("2")
            )
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @Test
    fun colons() {
        assertThat(StringAddCalculatorParser.parse("1,2:3"))
            .containsExactly(
                StringAddCalculatorNumber.of("1"),
                StringAddCalculatorNumber.of("2"),
                StringAddCalculatorNumber.of("3")
            )
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @Test
    fun customDelimiter() {
        assertThat(StringAddCalculatorParser.parse("//;\n1;2;3"))
            .containsExactly(
                StringAddCalculatorNumber.of("1"),
                StringAddCalculatorNumber.of("2"),
                StringAddCalculatorNumber.of("3")
            )
    }

    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    fun negative() {
        assertThatThrownBy { StringAddCalculatorParser.parse("-1") }
            .isInstanceOf(RuntimeException::class.java)
    }
}
