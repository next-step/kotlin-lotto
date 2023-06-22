package calculator

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class OperandTest {

    @Test
    fun `operand 가 숫자가 아닌 경우 예외가 발생한다`() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { Operand("a") }
    }

    @Test
    fun `operand 가 음수인 경우 예외가 발생한다`() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { Operand("-1") }
    }
}
