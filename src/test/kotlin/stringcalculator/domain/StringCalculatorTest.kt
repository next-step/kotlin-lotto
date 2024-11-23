package stringcalculator.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({
    "should return 0 when input is empty of null" {
        val stringCalculator = StringCalculator()
        stringCalculator.add(null) shouldBe 0
        stringCalculator.add("") shouldBe 0
    }

    "should return the number itself when a single number is input" {
        val calculator = StringCalculator()
        calculator.add("5") shouldBe 5
        calculator.add("100") shouldBe 100
    }
})
