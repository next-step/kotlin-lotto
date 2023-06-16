package stringCalculatorTest

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import stringCalculator.StringCalculator
import stringCalculator.StringParser

class StringCalculatorTest {
    @Test
    fun `구분자를 기준으로 분리한 각 숫자의 합을 반환 한다`() {
        val inputString = "1:5,9"
        val stringParser = StringParser()
        val parsedStringList = stringParser.parse(inputString)

        val stringCalculator = StringCalculator(parsedStringList)

        stringCalculator.execute() shouldBe 15
    }
}