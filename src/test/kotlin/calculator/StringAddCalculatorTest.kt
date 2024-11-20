package calculator

import calculator.StringAddCalculator.parse
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

object StringAddCalculator {
    fun parse(text: String): List<Int> {
        return text.split(",", ":").map { it.toInt() }
    }
}

class StringAddCalculatorTest : StringSpec({
    "쉼표를 통해 문자에서 숫자를 분리한다" {
        val text = "1,2,3"
        parse(text) shouldBe listOf(1, 2, 3)
    }

    "콜론을 통해 숫자를 분리한다" {
        val text = "1:2:3"
        parse(text) shouldBe listOf(1, 2, 3)
    }
})