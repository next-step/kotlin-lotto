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

    @ParameterizedTest(name = "연산식 : {0}")
    @ValueSource(strings = ["1,2", "3,5", "100,100"])
    fun `숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`(rawExpression: String) {
        val expected = rawExpression.split(Regex(",|:")).sumOf { it.toInt() }

        val expression = Expression(rawExpression, CustomSeparatorRegexStrategy)
        val result = calculator.calculate(expression)
        val actual = result.result

        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "연산식 : {0}")
    @ValueSource(strings = ["1,2", "1:3", "1,2:3"])
    fun `구분자를 쉼표 이외에 콜론을 사용할 수 있다`(rawExpression: String) {
        val expected = rawExpression.split(Regex(",|:")).sumOf { it.toInt() }

        val expression = Expression(rawExpression, CustomSeparatorRegexStrategy)
        val result = calculator.calculate(expression)
        val actual = result.result

        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "연산식 : {0}")
    @ValueSource(strings = ["//;\n1;2;3", "//,\n1,2,3", "//%\n1%2%3"])
    fun `더블 슬래시와 개행문자 사이에 커스텀 구분자를 지정할 수 있다`(rawExpression: String) {
        val expression = Expression(rawExpression, CustomSeparatorRegexStrategy)
        val calculateExpression = expression.calculateExpression()
        val separator = rawExpression[2].toString()

        val expected = calculateExpression.split(separator).sumOf { it.toInt() }

        val result = calculator.calculate(expression)
        val actual = result.result

        assertThat(actual).isEqualTo(expected)
    }
}
