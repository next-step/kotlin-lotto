package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class StringAdditionCalculatorTest {
    @Test
    fun `when input is empty should return 0`() {
        val result = StringAdditionCalculator.add("")

        result shouldBe 0
    }

    @Test
    fun `when input is blank should return 0`() {
        val result = StringAdditionCalculator.add("   ")

        result shouldBe 0
    }
}
