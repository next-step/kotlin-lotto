package stringCalculatorTest

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import stringCalculator.ParsedStringValidator
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

        val stringCalculator = StringCalculator(ParsedStringValidator)
        stringCalculator.execute(parsedStringList) shouldBe expected
    }

    @Test
    fun `기본 구분자와 커스텀 구분자를 기준으로 분리한 각 숫자의 합을 반환 한다`() {
        val inputString = "//구\n1:8구9"
        val stringParser = StringParser()
        val parsedStringList = stringParser.parse(inputString)

        val stringCalculator = StringCalculator(ParsedStringValidator)
        stringCalculator.execute(parsedStringList) shouldBe 18
    }

    @Test
    fun `계산기 음수 입력값 테스트`() {
        val inputString = "-1:8,9"
        val stringParser = StringParser()
        val parsedStringList = stringParser.parse(inputString)

        shouldThrow<RuntimeException> {
            StringCalculator(ParsedStringValidator).execute(parsedStringList)
        }
    }

    @Test
    fun `계산기 숫자 이외의 입력값 테스트`() {
        val inputString = "1:8,AA"
        val stringParser = StringParser()
        val parsedStringList = stringParser.parse(inputString)

        shouldThrow<RuntimeException> {
            StringCalculator(ParsedStringValidator).execute(parsedStringList)
        }
    }
}
