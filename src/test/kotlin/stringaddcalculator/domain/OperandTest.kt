package stringaddcalculator.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class OperandTest {
    @Test
    @DisplayName("음수가 들어오면 에러가 발생한다.")
    internal fun negativeNumberOccurException() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Operand(-1) }
    }

    @Test
    @DisplayName("입력으로 들어온 문자열 숫자가 올바르지 않으면 에러가 발생한다.")
    internal fun stringNumberNotInvalid() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Operand.of("d") }
    }

    @Test
    @DisplayName("operator overloading 으로 연산 수행이 가능하다.")
    internal fun plusOperatorOverloading() {
        val result = Operand(1) + Operand(2)
        assertThat(result).isEqualTo(Operand(3))
    }
}
