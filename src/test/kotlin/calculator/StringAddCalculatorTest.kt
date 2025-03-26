package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : FunSpec({
    val calculator by lazy { StringAddCalculator() }

    context("Returns 0 when the input is null or empty") {
        withData(
            null to 0,
            "" to 0,
            "   " to 0,
        ) { (actual, expected) ->
            calculator.add(actual) shouldBe expected
        }
    }

    context("Returns the number when a single number is provided") {
        withData(
            "1" to 1,
            "11" to 11,
            "100" to 100,
            "7890" to 7890,
        ) { (actual, expected) ->
            calculator.add(actual) shouldBe expected
        }
    }

    test("Returns the sum of two numbers separated by a comma") {
        val actual = "1,2,3,4,5"

        calculator.add(actual) shouldBe 15
    }
})
