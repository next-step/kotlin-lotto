package calculator

import io.kotest.assertions.throwables.shouldThrow
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

    @Test
    fun `when input is a single number should return the number`() {
        val result = StringAdditionCalculator.add("5")

        result shouldBe 5
    }

    @Test
    fun `when input has numbers separated by default delimiters should add numbers`() {
        val result = StringAdditionCalculator.add("1,2:3")

        result shouldBe 6
    }

    @Test
    fun `when input has nun-numeric values should throw exception`() {
        shouldThrow<RuntimeException> { StringAdditionCalculator.add("1,%:3") }
    }

    @Test
    fun `when input has negative numbers should throw exception`() {
        shouldThrow<RuntimeException> { StringAdditionCalculator.add("1,-2:3") }
    }

    @Test
    fun `when input has custom delimiter should split numbers`() {
        val result = StringAdditionCalculator.add("//?\n1?2:3")

        result shouldBe 6
    }

    @Test
    fun `when custom delimiter is not in the start of the input should throw exception`() {
        shouldThrow<RuntimeException> { StringAdditionCalculator.add("1?2:3//?\n") }
    }
}
