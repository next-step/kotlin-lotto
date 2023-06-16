package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    private val calculator = StringAddCalculator()

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    fun emptyOrNull(text: String?) {
        assertEquals(calculator.add(text), 0)
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1"])
    fun oneNumber(text: String) {
        assertThat(calculator.add(text)).isSameAs(Integer.parseInt(text))
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun twoNumbers(text: String) {
        assertThat(calculator.add(text)).isSameAs(3)
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun colons(text: String) {
        assertThat(calculator.add(text)).isSameAs(6)
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun customDelimiter(text: String) {
        assertThat(calculator.add(text)).isSameAs(6)
    }

    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    fun negative() {
        assertThrows<RuntimeException> {
            calculator.add("-1")
        }
    }

    @DisplayName(value = "문자열 계산기의 extractCustomDelimiter 함수가 custom delimiter 를 분리한다")
    @ParameterizedTest
    @ValueSource(strings = ["//@\n1:2@4"])
    fun extractText(text: String) {
        assertThat(calculator.extractCustomDelimiter(text)).isEqualTo("1:2@4")
    }

    @DisplayName(value = "문자열 계산기의 extractCustomDelimiter 함수가 string 을 delimiter 를 이용하여 토큰으로 분리한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2:3:4,5"])
    fun splitText(text: String) {
        assertThat(calculator.splitter(text, listOf(":", ","))).isEqualTo(listOf("1", "2", "3", "4", "5"))
    }

    @DisplayName(value = "문자열 계산기의 convertTokensToNum 함수가 string 을 int 로 변환한다")
    @Test
    fun convertTokensToNum() {
        val tokens = listOf("1", "2", "3")
        assertThat(calculator.convertTokensToNumber(tokens)).isEqualTo(listOf(1, 2, 3))
    }

    @DisplayName(value = "Unhappy Path - 유효하지 않은 입력값에 대해 convertTokensToNum 함수가 예외를 처리한다")
    @Test
    fun convertTokensToNumWithInvalidValue() {
        val tokens = listOf("1", "2", "@")
        assertThrows<RuntimeException> {
            calculator.convertTokensToNumber(tokens)
        }
    }
}
