package stringCalculatorTest

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import stringCalculator.ParsedStringValidator
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
}
