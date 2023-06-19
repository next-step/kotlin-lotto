package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["1,2=3", "2,3,4=9", "2:5:1=8"], delimiter = '=')
    fun calculate(expression: String, expected: Long) {
        val calculator = StringCalculator()

        val result = calculator.calculate(expression)

        result shouldBe expected
    }

}
