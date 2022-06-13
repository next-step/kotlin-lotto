package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class OperandTest {
    @ParameterizedTest
    @ValueSource(strings = ["+", "a", "ㅎㅎ"])
    fun `숫자가 아닌 입력값이 있는 경우 예외`(input: String) {
        assertThrows<RuntimeException> { Operand.from(input) }
            .also { Assertions.assertThat(it.message).isEqualTo("피연산자는 숫자만 입력하실 수 있습니다.") }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-99", "-2100000000"])
    fun `음수인 경우 예외`(input: String) {
        assertThrows<RuntimeException> { Operand.from(input) }
            .also { Assertions.assertThat(it.message).isEqualTo("피연산자는 0이상의 수만 입력하실 수 있습니다.") }
    }
}
