package stringcalculator.domain

import io.kotest.assertions.throwables.shouldThrow
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
        calculator.add("16:7") shouldBe 23
        calculator.add("2,5:19") shouldBe 26
    }

    "should return the sum of numbers split by custom delimiters" {
        val calculator = StringCalculator()
        calculator.add("//;\n3:5") shouldBe 8
        calculator.add("//|\n11|22|33") shouldBe 66
        calculator.add("//.\n1.2,3:4") shouldBe 10
        calculator.add("//\n1:2,3") shouldBe 6
    }

    "should throw RuntimeException for negative numbers" {
        val calculator = StringCalculator()
        val exception =
            shouldThrow<RuntimeException> {
                calculator.add("19,-5,3")
            }
        exception.message shouldBe "Negative numbers are not allowed: -5"
    }

    "should throw RuntimeException for non-numeric values" {
        val calculator = StringCalculator()
        val exception =
            shouldThrow<RuntimeException> {
                calculator.add("5,22,S")
            }
        exception.message shouldBe "Invalid number: S"
    }
})
