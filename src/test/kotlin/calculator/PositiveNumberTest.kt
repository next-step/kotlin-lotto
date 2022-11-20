package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class PositiveNumberTest {

    @Test
    @DisplayName("음수는 생성시 RuntimeException 이 발생한다.")
    internal fun createExceptionTest() {
        // given

        // when, then
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { PositiveNumber.of("-1") }
    }


    @Test
    @DisplayName("plus가 정상동작한다.")
    internal fun plusTest() {
        // given
        val numberA = PositiveNumber(1)
        val numberB = PositiveNumber(2)

        // when
        val plusPositiveNumber = numberA + numberB

        // then
        assertThat(plusPositiveNumber).isEqualTo(PositiveNumber(3))
    }
}
