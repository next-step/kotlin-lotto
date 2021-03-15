package stringadder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class OperandTest {

    @DisplayName("인자로 0 이상의 숫자가 들어온 경우 객체 생성")
    @Test
    fun validate() {
        assertThat(Operand("1")).isNotNull
    }

    @DisplayName("인자로 숫자가 아닌 값이 들어온 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = ["a", "A", "*", "-"])
    fun validateNumber(input: String) {
        assertThrows<IllegalArgumentException> { Operand(input) }
    }

    @DisplayName("인자로 음수가 들어온 경우 예외 발생")
    @Test
    fun validatePositive() {
        assertThrows<IllegalArgumentException> { Operand("-1") }
    }
}
