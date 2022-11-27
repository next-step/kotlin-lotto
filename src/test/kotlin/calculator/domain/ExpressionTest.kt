package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExpressionTest {

    @Test
    fun `수식 클래스 생성하여 파라미터 값 비교`() {
        // given
        val value = "1,2:3"

        // when
        val expression = Expression(value)
        val actual = expression.value == value

        // then
        assertThat(actual).isTrue
    }


}