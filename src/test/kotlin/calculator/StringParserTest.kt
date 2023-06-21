package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringParserTest {

    @Test
    fun `커스텀 구분자를 사용하여 문자열을 파싱한다`() {
        val stringParser = StringParser()

        val result = stringParser.parsingNumbers("//;\n1;2;3")

        result shouldBe PositiveNumbers(listOf(PositiveNumber(1), PositiveNumber(2), PositiveNumber(3)))
    }

    @Test
    fun `기본 구분자 콤마를 사용하여 파싱한다`() {
        val stringParser = StringParser()

        val result = stringParser.parsingNumbers("1,2,3")

        result shouldBe PositiveNumbers(listOf(PositiveNumber(1), PositiveNumber(2), PositiveNumber(3)))
    }

    @Test
    fun `기본 구분자 콜론을 사용하여 파싱한다`() {
        val stringParser = StringParser()

        val result = stringParser.parsingNumbers("2:3:4")

        result shouldBe PositiveNumbers(listOf(PositiveNumber(2), PositiveNumber(3), PositiveNumber(4)))
    }

    @Test
    fun `정의되지 않은 구분자를 사용하면 예외가 발생한다`() {
        val stringParser = StringParser()

        shouldThrow<IllegalArgumentException> { stringParser.parsingNumbers("2!3!4") }
    }

    @ParameterizedTest
    @CsvSource(value = ["-1:1", "1:!", "a:2:!"])
    fun `숫자가 아니거나 음수인 경우 예외가 발생한다`(text: String) {
        val stringParser = StringParser()

        shouldThrow<RuntimeException> { stringParser.parsingNumbers(text) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "20", "101"])
    fun `문자열이 하나의 숫자로 이루어진 경우 해당 숫자를 반환한다`(text: String) {
        val stringParser = StringParser()

        val result = stringParser.parsingNumbers(text)

        result shouldBe PositiveNumbers(listOf(PositiveNumber(text.toLong())))
    }
}
