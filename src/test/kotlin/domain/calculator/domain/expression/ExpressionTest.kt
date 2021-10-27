package domain.calculator.domain.expression

import domain.calculator.domain.operand.PositiveOperand
import domain.calculator.strategy.CustomSeparatorRegexStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("연산식(Expression)")
class ExpressionTest {

    @Test
    fun `null 값이 들어오면 0값 문자열을 반환한다`() {
        val nullString: String? = null
        val expression = Expression(nullString, CustomSeparatorRegexStrategy)

        assertThat(expression.calculateExpression()).isEqualTo("0")
    }

    @ParameterizedTest(name = "공백 연산값: `{0}`")
    @ValueSource(strings = ["", " ", "   "])
    fun `공백값으로 이루어진 문자열이 들어오면 0값 문자열을 반환한다`(emptyString: String) {
        val expression = Expression(emptyString, CustomSeparatorRegexStrategy)

        assertThat(expression.calculateExpression()).isEqualTo("0")
    }

    @ParameterizedTest(name = "연산식: `{0}`")
    @ValueSource(strings = ["//;\n1;2;3", "//,\n1,2,3", "//^\n1^2^3"])
    fun `커스텀 구분자가 들어오면, 커스텀 구분자로 나눈후 덧셈 연산을 진행한다`(rawExpression: String) {
        val expression = Expression(rawExpression, CustomSeparatorRegexStrategy)
        val actual = expression.calculateExpression()
        val expected = Regex(CustomSeparatorRegexStrategy.SEPARATOR_REGEX).find(rawExpression)!!.groupValues[2]

        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "연산식: `{0}`")
    @ValueSource(strings = ["", "1", "1,2", "1,2:3"])
    fun `커스텀 구분자가 아닌데 커스텀 구분자를 찾으려고 하면 에러가 발생한다`(rawExpression: String) {
        val expression = Expression(rawExpression, CustomSeparatorRegexStrategy)

        assertThrows<RuntimeException> { expression.customSeparatorExpression() }
    }

    @ParameterizedTest(name = "연산식: `{0}`")
    @ValueSource(strings = ["1", "1,2", "1,2:3"])
    fun `커스텀 구분자가 없는 입력된 연산식에서 실제 계산될 연산 숫자들을 리스트로 반환한다`(rawExpression: String) {
        val expected = rawExpression.split(Regex(",|:")).asSequence()
            .map { PositiveOperand(it.toInt()) }
            .toList()

        val expression = Expression(rawExpression, CustomSeparatorRegexStrategy)
        val actual = expression.split(",|:")

        assertThat(actual).isEqualTo(expected)
    }
}
