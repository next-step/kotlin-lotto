package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExpressionTest {

    @Test
    fun `기본 구분자를 반환`() {
        val expression = Expression("1,2:3")
        assertThat(expression.delimiter()).containsExactlyInAnyOrder(",", ":")
    }

    @Test
    fun `커스텀 구분자를 반환`() {
        val expression = Expression("//;\n1;2;3")
        assertThat(expression.delimiter()).containsExactly(";")
    }

    @Test
    fun `기본 구분자일 경우 문자열 수식 반환`() {
        val expression = Expression("1,2:3")
        assertThat(expression.parsedExpression()).isEqualTo("1,2:3")
    }

    @Test
    fun `커스텀 구분자일 경우 문자열 수식 반환`() {
        val expression = Expression("//;\n1;2;3")
        assertThat(expression.parsedExpression()).isEqualTo("1;2;3")
    }
}
