package calculator.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class OperandTest {

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열은 또는 null 값이 입력되면 0을 반환한다`(value: String?) {
        Assertions.assertThat(Operand.of(value)).isEqualTo(Operand.ZERO)
    }

    @ParameterizedTest
    @ValueSource(strings = ["k", "o", "t", "l", "i", "n"])
    fun `숫자가 아닌 문자는 피연산자가 될 수 없다`(value: String) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Operand.of(value) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-10", "-100", "-20"])
    fun `음수인 정수는 피연산자가 될 수 없다`(value: String) {
        Assertions.assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { Operand.of(value) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "100", "20"])
    fun `양수인 정수는 피연산자가 될 수 있다`(value: String) {
        Assertions.assertThat(Operand.of(value).value).isEqualTo(value.toInt())
    }
}
