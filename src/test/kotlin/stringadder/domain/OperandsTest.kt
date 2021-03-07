package stringadder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class OperandsTest {

    @DisplayName("Operand 리스트의 합 반환")
    @Test
    fun sum() {
        val list = listOf("1", "2", "3")
        val operands = createOperands(*list.toTypedArray())

        val actual = operands.sum()
        val expected = list.map { it.toInt() }.sum()

        assertThat(actual).isEqualTo(expected)
    }
}