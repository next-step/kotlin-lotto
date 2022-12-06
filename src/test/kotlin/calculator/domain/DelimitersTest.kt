package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class DelimitersTest {

    @Test
    fun `문자열 구분자를 이용히여 연산자로 변환한다`() {
        // given
        val input = "//;\n1;2;3"

        // when
        val actual = Delimiters.create(input).toOperator(";")

        // then
        val expected = Operator.PLUS
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `문자열 구분자를 이용하여 연산자 변환에 실패한다`() {
        assertThrows<IllegalArgumentException> {
            // given
            val input = "//;\n1;2;3"

            // when
            val actual = Delimiters.create(input).toOperator("ㅇ")
        }
    }
}
