package domain.calculator.domain.expression

import domain.calculator.strategy.CustomSeparatorRegexStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
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
}
