package stringadditioncalculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class StringAdditionCalculatorTest {

    @Test
    fun `문자열 덧셈 계산기는 빈값("")이 들어오면 0을 반환한다`() {
        val calculator = StringAdditionCalculator()
        val input = ""
        val actual = calculator.calculate(input)

        actual shouldBe 0
    }
}
