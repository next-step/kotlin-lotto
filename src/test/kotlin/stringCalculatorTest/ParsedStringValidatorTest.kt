package stringCalculatorTest

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import stringCalculator.ParsedStringValidator
import stringCalculator.StringParser

class ParsedStringValidatorTest {
    @ParameterizedTest
    @CsvSource(
        "1:5,-9",
        "1:-5,9",
        "-1:5,9",
        delimiter = '*'
    )
    fun `음수를 전달하는 경우 RuntimeException 예외를 throw 한다`(inputString: String) {
        val stringParser = StringParser()
        val parsedStringList = stringParser.parse(inputString)

        ParsedStringValidator.check(parsedStringList) shouldBe false
    }

    @ParameterizedTest
    @CsvSource(
        "한:5,9",
        "1:글,9",
        "1:5,eng",
        delimiter = '*'
    )
    fun `숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 throw 한다`(inputString: String) {
        val stringParser = StringParser()
        val parsedStringList = stringParser.parse(inputString)

        ParsedStringValidator.check(parsedStringList) shouldBe false
    }

    @Test
    fun `커스텀 구분자를 포함하고 음수를 전달하는 경우 RuntimeException 예외를 throw 한다`() {
        val inputString = "//구\n1:8구-9"
        val stringParser = StringParser()
        val parsedStringList = stringParser.parse(inputString)

        ParsedStringValidator.check(parsedStringList) shouldBe false
    }

    @Test
    fun `커스텀 구분자를 포함하고 숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 throw 한다`() {
        val inputString = "//구\n1:8구eng"
        val stringParser = StringParser()
        val parsedStringList = stringParser.parse(inputString)

        ParsedStringValidator.check(parsedStringList) shouldBe false
    }
}