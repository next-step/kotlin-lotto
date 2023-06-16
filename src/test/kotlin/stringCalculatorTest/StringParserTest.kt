package stringCalculatorTest

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import stringCalculator.StringParser

class StringParserTest {
    @Test
    fun `쉼표 또는 구분자로 문자열을 분리한다`() {
        val inputString = "1:5,9"
        val stringParser = StringParser()
        stringParser.parse(inputString) shouldBe listOf("1","5","9")
    }
}
