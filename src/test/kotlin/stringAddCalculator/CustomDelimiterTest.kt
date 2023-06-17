package stringAddCalculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import stringAddCalculator.customDelimiter.DoubleAsteriskDelimiter
import stringAddCalculator.customDelimiter.DoubleSlashAndNewLineDelimiter

class CustomDelimiterTest {

    @Test
    fun `DoubleSlashAndNewLineDelimiter 테스트`() {
        val expression = "//@\n1@2,3"
        val customDelimiter = DoubleSlashAndNewLineDelimiter()

        val parserResult = customDelimiter.parse(expression)

        parserResult?.customDelimiter shouldBe "@"
        parserResult?.expression shouldBe "1@2,3"
    }

    @Test
    fun `DoubleAsteriskDelimiter 테스트`() {
        val expression = "3,5>6**>"
        val customDelimiter = DoubleAsteriskDelimiter()

        val parserResult = customDelimiter.parse(expression)

        parserResult?.customDelimiter shouldBe ">"
        parserResult?.expression shouldBe "3,5>6"
    }
}
