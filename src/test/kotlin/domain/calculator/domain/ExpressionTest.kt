package domain.calculator.domain

import domain.calculator.domain.expression.Expression
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

        assertThat(expression.calculationExpression()).isEqualTo("0")
    }

    @ParameterizedTest(name = "공백 연산값: `{0}`")
    @ValueSource(strings = ["", " ", "   "])
    fun `공백값으로 이루어진 문자열이 들어오면 0값 문자열을 반환한다`(emptyString: String) {
        val expression = Expression(emptyString, CustomSeparatorRegexStrategy)

        assertThat(expression.calculationExpression()).isEqualTo("0")
    }

    @ParameterizedTest(name = "연산식: `{0}`")
    @ValueSource(strings = ["//;\n1;2;3", "//|\n1|2|3", "//,\n1,2,3", "//^\n1^2^3"])
    fun `공백값으로 이루어진 문자열이 들어오면 0값 `(rawExpression: String) {
        val expected = Regex(CustomSeparatorRegexStrategy.SEPARATOR_REGEX).find(rawExpression)!!.groupValues[2]
        val expression = Expression(rawExpression, CustomSeparatorRegexStrategy)
        val actual = expression.calculationExpression()

        assertThat(actual).isEqualTo(expected)
    }
}
