package domain.calculator.service

import domain.calculator.domain.expression.Expression
import domain.calculator.strategy.CustomSeparatorRegexStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("계산기(Calculator)")
class CalculatorTest {
    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator
    }

    @ParameterizedTest(name = "연산식 : {0}")
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다`(rawExpression: String?) {
        val expression = Expression(rawExpression, CustomSeparatorRegexStrategy)
        val result = calculator.calculate(expression)
        assertThat(result.result).isZero
    }

    @ParameterizedTest(name = "연산식 : {0}")
    @ValueSource(strings = ["1", "100", Integer.MAX_VALUE.toString()])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(rawExpression: String) {
        val expression = Expression(rawExpression, CustomSeparatorRegexStrategy)
        val result = calculator.calculate(expression)

        assertThat(result.result).isEqualTo(Integer.valueOf(rawExpression))
    }

    // @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    // @ParameterizedTest
    // @ValueSource(strings = ["1,2"])
    // fun twoNumbers(text: String) {
    //     assertThat(calculator.add(text)).isSameAs(3);
    // }
    //
    // @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    // @ParameterizedTest
    // @ValueSource(strings = ["1,2:3"])
    // fun colons(text: String) {
    //     assertThat(calculator.add(text)).isSameAs(6);
    // }
    //
    // @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    // @ParameterizedTest
    // @ValueSource(strings = ["//;\n1;2;3"])
    // fun customDelimiter(text: String) {
    //     assertThat(calculator.add(text)).isSameAs(6);
    // }
    //
    // @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    // @Test
    // fun negative() {
    //     assertThatExceptionOfType(RuntimeException::class.java)
    //         .isThrownBy(() -> calculator.add("-1"));
    // }
}
