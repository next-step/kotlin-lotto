package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    fun calculate() {
        val calculator = StringCalculator()

        val result = calculator.calculate("1,2")

        result shouldBe 3
    }

}
