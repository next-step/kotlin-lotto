package domain

import calculator.domain.Operand
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class OperandTest {
    @ParameterizedTest
    @ValueSource(strings = ["a", "테스트", "-1", "-2", "!"])
    fun `잘못된 값을 입력하면 IllegalArgumentException이 발생한다`(input: String) {
        Assertions.assertThatThrownBy {
            Operand.from(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4", "100", "9999"])
    fun `정상적인 값을 입력하면 Operand가 정상적으로 생성된다`(input: String) {
        val operand = Operand.from(input)

        assertThat(operand.value).isEqualTo(input.toInt())
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `null이나 빈문자열을 입력하면 값이 0인 Operand가 생성된다`(input: String?) {
        val operand = Operand.from(input)

        assertThat(operand.value).isEqualTo(0)
    }
}
