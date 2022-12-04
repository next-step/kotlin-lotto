package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ExpressionTest {

    @Test
    fun `입력값을 이용하여 수식을 만든다`() {
        // given
        val input = "//;\n1;2;3"
        val delimiters = Delimiters.create(input)

        // when
        val expression = Expression.create(input, delimiters)
        val actual = expression.value.size

        // then
        val expected = 5
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `구분자 외에 다른 문자가 입력되어 수식 만들기 실패`() {
        assertThrows<IllegalArgumentException> {
            val input = "//;\n1;2;3ddd"
            val delimiters = Delimiters.create(input)

            // when
            val expression = Expression.create(input, delimiters)
            val actual = expression.value.size

            // then
            val expected = 5
            assertThat(actual).isEqualTo(expected)
        }
    }
}
