package string.addition.caculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperandTest {

    @ParameterizedTest
    @ValueSource(strings = ["1", "123", "11", "5"])
    fun `An operand from the input string should be a Number`(inputStr: String) {
        // given
        val expected = inputStr.toInt()

        // when
        val operand = Operand(inputStr)

        // then
        assertThat(operand).extracting("number").isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["tom", "jerry", "man", "woman"])
    fun `An operand from the input string cannot be a non-digit string`(inputStr: String) {
        // then
        assertThrows<RuntimeException> { Operand(inputStr) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-123", "-11", "-5"])
    fun `An operand from the input string should be greater than zero`(inputStr: String) {
        // then
        assertThrows<RuntimeException> { Operand(inputStr) }
    }
}
