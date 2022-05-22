package string.addition.caculator.application

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class AdditionTest {
    @Test
    fun `Add every operands 1`() {
        // given
        val targetNumbers = "1,2,3"
        val expected = 6
        val operands = OperandParser.parse(targetNumbers)

        // when
        val result = Addition(operands).result()

        // then
        Assertions.assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `Add every operands 2`() {
        // given
        val targetNumbers = "123:2:35"
        val expected = 160
        val operands = OperandParser.parse(targetNumbers)

        // when
        val result = Addition(operands).result()

        // then
        Assertions.assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `Add every operands 3`() {
        // given
        val targetNumbers = "//!\\n13!25!13"
        val expected = 51
        val operands = OperandParser.parse(targetNumbers)

        // when
        val result = Addition(operands).result()

        // then
        Assertions.assertThat(result).isEqualTo(expected)
    }
}
