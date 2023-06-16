package stringCalculatorTest

import io.kotest.assertions.throwables.shouldThrow
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
        "//구\n1:5구-9",
        "//분\n1:-5분9",
        "//자\n-1:5자9",
        delimiter = '*'
    )
    fun `음수를 전달하는 경우 RuntimeException 예외를 throw 한다`(inputString: String) {
        val stringParser = StringParser()
        val parsedStringList = stringParser.parse(inputString)

        println(parsedStringList)
        val parsedStringValidator = ParsedStringValidator(parsedStringList)
        shouldThrow<RuntimeException> {
            parsedStringValidator.check()
        }
    }

    @ParameterizedTest
    @CsvSource(
        "한:글,9",
        "1:eng,9",
        "//구\n한:8구9",
        "//분\n1:eng분9",
    )
    fun `숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 throw 한다`(inputString: String) {
        val stringParser = StringParser()
        val parsedStringList = stringParser.parse(inputString)

        val parsedStringValidator = ParsedStringValidator(parsedStringList)
        shouldThrow<RuntimeException> {
            parsedStringValidator.check()
        }
    }
}