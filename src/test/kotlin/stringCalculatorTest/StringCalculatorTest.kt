package stringCalculatorTest

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import stringCalculator.StringCalculator
import stringCalculator.StringParser

class StringCalculatorTest {
    @ParameterizedTest
    @CsvSource(
        "1:5,9 15",
        "1:1,1 3",
        delimiter = ' '
    )
    fun `구분자를 기준으로 분리한 각 숫자의 합을 반환 한다`(inputString: String, expected: Int) {
        val stringParser = StringParser()
        val parsedStringList = stringParser.parse(inputString)

        val stringCalculator = StringCalculator(parsedStringList)
        stringCalculator.execute() shouldBe expected
    }

    @Test
    fun `기본 구분자와 커스텀 구분자를 기준으로 분리한 각 숫자의 합을 반환 한다`() {
        val inputString = "//구\n1:8구9"
        val stringParser = StringParser()
        val parsedStringList = stringParser.parse(inputString)

        println(parsedStringList)
        val stringCalculator = StringCalculator(parsedStringList)
        stringCalculator.execute() shouldBe 18
    }
}