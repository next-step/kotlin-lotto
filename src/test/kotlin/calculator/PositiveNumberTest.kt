package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PositiveNumberTest {

    @Test
    fun `양수끼리 덧셈이 가능하다`() {
        //given
        val positiveNumber = PositiveNumber.ofString("1")
        val positiveNumber2 = PositiveNumber.ofString("2")

        //when
        //then
        assertThat(positiveNumber.sum(positiveNumber2)).isEqualTo(PositiveNumber(3))
    }

    @Test
    fun `음수는 생성 불가능하다`() {
        assertThrows<RuntimeException> { PositiveNumber.ofString("-1") }
    }

    @Test
    fun `숫자 이외의 값은 생성 불가능하다`() {
        assertThrows<RuntimeException> { PositiveNumber.ofString("?") }
    }
}