package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class StringCalculatorParserTest {

    @ParameterizedTest
    @CsvSource(value = ["1,2,3:,:1,2,3", "34;43;43:;:34,43,43", "1!2!3:!:1,2,3"], delimiter = ':')
    fun `특정 구분자로 문자열을 파싱한다`(input: String, delimiter: String, expected: String) {
        // given
        val stringCalculatorParser = StringCalculatorParser()

        // when
        val result = stringCalculatorParser.parse(input, delimiter)

        // then
        val expect = expected.split(',')
        assertThat(result).containsAll(expect)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "1;2;3", "1,2;3"])
    fun `쉼표 또는 콜론을 구분자로 문자열을 파싱한다`(input: String) {
        // given
        val stringCalculatorParser = StringCalculatorParser()

        // when
        val result = stringCalculatorParser.parse(input)

        // then
        assertThat(result).containsExactly(1, 2, 3)
    }

    @Test
    fun `문자열이 커스텀 구분자를 포함하면 true를 반환한다`() {
        // given
        val stringCalculatorParser = StringCalculatorParser()
        val input = "//;\n1;2;3"

        // when
        val result = stringCalculatorParser.hasCustomDelimiter(input)

        // then
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `문자열이 커스텀 구분자를 포함하지 않으면 false를 반환한다`() {
        // given
        val stringCalculatorParser = StringCalculatorParser()
        val input = "1;2;3"

        // when
        val result = stringCalculatorParser.hasCustomDelimiter(input)

        // then
        assertThat(result).isEqualTo(false)
    }

    @ParameterizedTest
    @MethodSource("provideNumbersAsString")
    fun `문자열이 커스텀 구분자를 포함하면 커스텀 구분자를 반환한다`(numbersAsString: String, expectedDelimiter: String, expectedData: String) {
        // given
        val stringCalculatorParser = StringCalculatorParser()

        // when
        val parsingData = stringCalculatorParser.parseDelimiter(numbersAsString)

        // then
        assertAll(
            { assertThat(parsingData.delimiter).isEqualTo(expectedDelimiter) },
            { assertThat(parsingData.data).isEqualTo(expectedData) },
        )
    }

    companion object {

        @JvmStatic
        fun provideNumbersAsString(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("//;\n1;2;3", ";", "1;2;3"),
                Arguments.of("//!\n1!2!3", "!", "1!2!3"),
                Arguments.of("//@\n1@2@3", "@", "1@2@3")
            )
        }
    }
}
