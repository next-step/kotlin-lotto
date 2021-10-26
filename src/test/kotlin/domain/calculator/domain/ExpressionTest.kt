package domain.calculator.domain

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
        val expression = Expression(nullString)

        assertThat(expression.expression).isEqualTo("0")
    }

    @ParameterizedTest(name = "공백 연산값: {0}")
    @ValueSource(strings = ["", " ", "   "])
    fun `공백값으로 이루어진 문자열이 들어오면 0값 문자열을 반환한다`(emptyString: String) {
        val expression = Expression(emptyString)

        assertThat(expression.expression).isEqualTo("0")
    }
}
