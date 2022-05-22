package string.addition.caculator.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import string.addition.caculator.domain.Operand

class OperandParserTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "1:2:3", "1,2:3"])
    fun `parse string by default delimiter`(inputStr: String) {
        // given
        val expected = (1..3).map { Operand(it.toString()) }

        // when
        val result = OperandParser.parse(inputStr)

        // then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `parse empty string by delimiter return empty operand list`() {
        // given
        val emptyString = String()
        val expected = listOf(Operand.zero)

        // when
        val result = OperandParser.parse(emptyString)

        // then
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\\n1;2;3", "//!\\n1!2!3", "//f\\n1f2f3"])
    fun `get custom delimiter btw double slash and newline character`(inputStr: String) {
        // given
        val expected = (1..3).map { Operand(it.toString()) }

        // when
        val result = OperandParser.parse(inputStr)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
