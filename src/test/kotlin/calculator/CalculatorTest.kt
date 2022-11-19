package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.RuntimeException

internal class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4", "1.2,1.5,3,100", "0,1,3,1.3,20"])
    fun sum(numberList: String) {
        val numbers = numberList.split(",").map { it.toBigDecimal() }

        val result = Calculator.sum(numbers)
        numbers.reduce { total, number -> total + number } shouldBe result
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,-4", "1.2,1.5,-3,100", "-1,2,3", "-2.2"])
    fun `sum throw RuntimeException when number include zero`(numberList: String) {
        val numbers = numberList.split(",").map { it.toBigDecimal() }

        assertThrows<RuntimeException> {
            Calculator.sum(numbers)
        }
    }
}
