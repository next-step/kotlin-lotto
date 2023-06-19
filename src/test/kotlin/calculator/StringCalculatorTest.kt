package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["1,2=3", "2,3,4=9", "2:5:1=8"], delimiter = '=')
    fun `문자열을 전달하면 계산된 결과를 반환한다`(expression: String, expected: Long) {
        val calculator = StringCalculator()

        val result = calculator.calculate(expression)

        result shouldBe expected
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `null 또는 empty 문자열을 전달하면 0이 반환된다`(expression: String?) {
        val calculator = StringCalculator()

        val result = calculator.calculate(expression)

        result shouldBe 0
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "20", "101"])
    fun `문자열이 하나의 숫자로 이루어진 경우 해당 숫자를 반환한다`(expression: String) {
        val calculator = StringCalculator()

        val result = calculator.calculate(expression)

        result shouldBe expression.toLong()
    }

    @ParameterizedTest
    @CsvSource(value = ["-1:1", "1:!", "a:2:!"])
    fun `숫자가 아니거나 음수인 경우 예외가 발생한다`(expression: String) {
        val calculator = StringCalculator()

        shouldThrow<RuntimeException> { calculator.calculate(expression) }
    }

    @Test
    fun `커스텀 구분자를 사용할 수 있다`() {
        val str = "//;\\n1;2;3"
        val calculator = StringCalculator()

        val result = calculator.calculate(str)

        result shouldBe 6
    }
}
