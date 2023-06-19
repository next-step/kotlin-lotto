package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

class StringAddCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["1,2=3", "2,3,4=9", "2:5:1=8"], delimiter = '=')
    fun `문자열을 전달하면 계산된 결과를 반환한다`(expression: String, expected: Long) {
        val calculator = StringAddCalculator()

        val result = calculator.calculate(expression)

        result shouldBe expected
    }

    @Test
    fun `커스텀 구분자를 포함한 문자열을 전달하면 계산된 결과를 반환한다`() {
        val calculator = StringAddCalculator()

        val result = calculator.calculate("//;\n1;2;3")

        result shouldBe 6
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `null 또는 empty 문자열을 전달하면 0이 반환된다`(expression: String?) {
        val calculator = StringAddCalculator()

        val result = calculator.calculate(expression)

        result shouldBe 0
    }
}
