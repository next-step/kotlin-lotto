package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : FunSpec({
    val calculator by lazy { StringAddCalculator() }

    context("returns 0 when the input is null or empty") {
        withData(
            null to 0,
            "" to 0,
            "   " to 0,
        ) { (actual, expected) ->
            calculator.add(actual) shouldBe expected
        }
    }

    context("returns the number when a single number is provided") {
        withData(
            "1" to 1,
            "11" to 11,
            "100" to 100,
            "7890" to 7890,
        ) { (actual, expected) ->
            calculator.add(actual) shouldBe expected
        }
    }

    test("returns the sum of two numbers separated by a comma") {
        val actual = "1,2,3,4,5"

        calculator.add(actual) shouldBe 15
    }

    test("allows colon (:) as an additional delimiter") {
        val actual = "1,2:3"

        calculator.add(actual) shouldBe 6
    }

    context("support custom delimiters between // and new line") {
        withData(
            "//;\n1;2;3" to 6,
            "1\n2//3" to 6,
        ) { (actual, expected) ->
            calculator.add(actual) shouldBe expected
        }
    }

    test("throw RuntimeException if negative numbers are present") {
        shouldThrow<RuntimeException> {
            calculator.add("-1")
        }
    }

    test("throw RuntimeException if not a number") {
        shouldThrow<RuntimeException> {
            calculator.add("1;ab")
        }
    }
})
