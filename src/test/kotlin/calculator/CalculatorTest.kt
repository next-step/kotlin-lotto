package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.RuntimeException
import java.math.BigDecimal

internal class CalculatorTest {

    @Test
    fun sum() {
        val numberOne = 2
        val numberTwo = 2.5
        val numbers = listOf(numberOne.toBigDecimal(), numberTwo.toBigDecimal())

        val result = Calculator.sum(numbers)
        assertThat(result).isEqualTo(BigDecimal.valueOf(numberOne + numberTwo))
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -3, Int.MIN_VALUE])
    fun `sum throw RuntimeException when number include negative number`(number: Int) {
        val numbers = listOf<BigDecimal>(BigDecimal.ONE, number.toBigDecimal())

        assertThrows<RuntimeException> {
            Calculator.sum(numbers)
        }
    }
}
