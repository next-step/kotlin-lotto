package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoNumberParserTest : StringSpec({
    "should parse a valid number " {
        val input = "1,2,3,4,5,6"
        val result = LottoNumberParser.parse(input)
        result shouldBe listOf(1, 2, 3, 4, 5, 6)
    }

    "should throw an exception for invalid input" {
        val input = "1,2,3,4,5"
        val exception =
            shouldThrow<IllegalArgumentException> {
                LottoNumberParser.parse(input)
            }
        exception.message shouldBe "A single lotto ticket should have 6 numbers"
    }

    "should throw an exception for invalid number" {
        val input = "1,2,3,4,5,46"
        val exception =
            shouldThrow<IllegalArgumentException> {
                LottoNumberParser.parse(input)
            }
        exception.message shouldBe "Lotto numbers should be between 1 and 45"
    }
})
