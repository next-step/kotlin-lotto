package stringcalculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumberParserTest : StringSpec({
    "should parse valid numbers and calculate the sum" {
        val parser = NumberParser()
        val numbers = parser.parse("1,2,3", Regex("[,:]"))
        numbers.sumOf { it.getValue() } shouldBe 6
    }

    "should throw RuntimeException for negative numbers" {
        val parser = NumberParser()
        shouldThrow<RuntimeException> {
            parser.parse("1,-2,3", Regex("[,:]"))
        }.message shouldBe "Negative numbers are not allowed: -2"
    }

    "should throw RuntimeException for non-numeric values" {
        val parser = NumberParser()
        shouldThrow<RuntimeException> {
            parser.parse("1,2,S", Regex("[,:]"))
        }.message shouldBe "Invalid number: S"
    }
})
