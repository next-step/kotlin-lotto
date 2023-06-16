package stringCalculatorTest

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import stringCalculator.StringParser

class StringParserTest {
    @Test
    fun `쉼표 또는 구분자로 문자열을 분리한다`() {
        val inputString = "1:5,9"
        val stringParser = StringParser()
        stringParser.parse(inputString) shouldBe listOf("1", "5", "9")
    }

    @Test
    @DisplayName("//와 \n 사이에 위치하는 문자를 커스텀 구분자로 사용한다.")
    fun `조건에 맞는 커스텀 구분자를 추가할 수 있다`() {
        val inputString = "//???\n1:5,9???10"
        val stringParser = StringParser()
        stringParser.parse(inputString) shouldBe listOf("1", "5", "9", "10")
    }

    @ParameterizedTest
    @CsvSource(
        "1:5,-9",
        "1:-5,9",
        "-1:5,9",
        "//구\n1:5,-9",
        "//분\n1:-5,9",
        "//자\n-1:5,9",
    )
    fun `음수를 전달하는 경우 RuntimeException 예외를 throw 한다`(inputString: String) {
        val stringParser = StringParser()
        val parsedStringList = stringParser.parse(inputString)

        val parsedStringValidator = ParsedStringValidator()
        shouldThrow<IllegalStateException> {
            parsedStringValidator.check(parsedStringList)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "한:글,9",
        "1:eng,9",
        "//구\n한:글,9",
        "//분\n1:eng,9",
    )
    fun `숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 throw 한다`(inputString: String) {
        val stringParser = StringParser()
        val parsedStringList = stringParser.parse(inputString)

        val parsedStringValidator = ParsedStringValidator()
        shouldThrow<IllegalStateException> {
            parsedStringValidator.check(parsedStringList)
        }
    }
}
