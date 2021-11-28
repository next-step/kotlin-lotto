package step1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    private val calculator = Calculator(Seperator())

    @ParameterizedTest
    @ValueSource(strings = ["6,2:4", "3,2:7", "1,8,3", "6:2:4", "6,6", "6:6", "12"])
    fun `합계`(expression: String) {
        val sum = calculator.sum(expression)
        assertEquals(12, sum)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun `커스텀 합계`(expression: String) {
        val sum = calculator.sum(expression)
        assertEquals(6, sum)
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    fun `null 또는 빈문자열 합계`(expression: String?) {
        val sum = calculator.sum(expression)
        assertEquals(0, sum)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-6,2:4", "-3,2:7", "1,-8,3", "6:2:-4"])
    fun `음수 연산시 에러`(expression: String) {
        assertThrows<RuntimeException> { calculator.sum(expression) }
    }

}
