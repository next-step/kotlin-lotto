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

    "should return the sum of numbers split by basic delimiters" {
        val calculator = StringCalculator()
        calculator.add("24,32") shouldBe 56
        calculator.add("16;7") shouldBe 23
        calculator.add("2,5;19") shouldBe 26
    }
})
