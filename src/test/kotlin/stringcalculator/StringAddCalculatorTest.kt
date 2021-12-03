package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.util.regex.Pattern

internal class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator()
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    fun emptyOrNull(stringExpression: String?) {
        assertThat(calculator.add(stringExpression)).isZero
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "5", "8", "9"])
    fun oneNumber(expression: String) {
        assertThat(calculator.add(expression)).isSameAs(Integer.parseInt(expression))
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2", "3,4", "5,6", "6,7", "7,8", "0,0", "5,5", "9,9"])
    fun twoNumbers(expression: String) {
        val expectedResultValue = expression.split(",")
            .sumOf { it.toInt() }

        assertThat(calculator.add(expression)).isSameAs(expectedResultValue)
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2:3", "4:5,6", "1:1:1", "9,9,9"])
    fun colons(expression: String) {
        val expectedResultValue = Pattern.compile("[,:]")
            .split(expression)
            .sumOf { it.toInt() }

        assertThat(calculator.add(expression)).isSameAs(expectedResultValue)
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3", "//@\n7@7@7", "//!\n9!8!7!6!5!4!3!2!1", "//#\n2#4#4", "//A\n1A2A3A4A5"])
    fun customDelimiter(expression: String) {
        val expectedResultValue = Regex("//(.)\n(.*)")
            .find(expression)?.let {
                it.groupValues[2].split(it.groupValues[1])
            }?.sumOf {
                it.toInt()
            }

        assertThat(calculator.add(expression)).isEqualTo(expectedResultValue)
    }

    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    fun negative() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { calculator.add("-1") }
    }
}
