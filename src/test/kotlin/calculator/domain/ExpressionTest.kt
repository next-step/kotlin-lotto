package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ExpressionTest {

    @Test
    fun `숫자만 있는 입력값을 이용하여 수식 생성하여 프로퍼티 비교`() {
        // given
        val value = "123"

        // when
        val expression = Expression(value)
        val actual = expression.value == value

        // then
        assertThat(actual).isTrue
    }

    @Test
    fun `숫자 외에 다른 문자가 포함되어 있어 생성 실패`() {
        assertThrows<IllegalArgumentException> {
            Expression("1;,2:34")
        }
    }
}