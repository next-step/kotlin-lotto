package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class StringParserTest {

    @ParameterizedTest
    @CsvSource(value = ["1,2,3:,:1,2,3", "34;43;43:;:34,43,43", "1!2!3:!:1,2,3"], delimiter = ':')
    fun `특정 구분자로 문자열을 파싱한다`(input: String, delimiter: String, expected: String) {
        // given
        val stringParser = StringParser()

        // when
        val result = stringParser.parse(input, delimiter)

        // then
        val expect = expected.split(',')
        assertThat(result).containsAll(expect)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "1;2;3", "1,2;3"])
    fun `쉼표 또는 콜론을 구분자로 문자열을 파싱한다`(input: String) {
        // given
        val stringParser = StringParser()

        // when
        val result = stringParser.parse(input)

        // then
        assertThat(result).containsExactly("1","2","3")
    }

    @Test
    fun `문자열이 커스텀 구분자를 포함하면 true를 반환한다`() {
        // given
        val stringParser = StringParser()
        val input = "//;\n1;2;3"

        // when
        val result = stringParser.hasCustomDelimiter(input)

        // then
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `문자열이 커스텀 구분자를 포함하지 않으면 false를 반환한다`() {
        // given
        val stringParser = StringParser()
        val input = "1;2;3"

        // when
        val result = stringParser.hasCustomDelimiter(input)

        // then
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `문자열이 커스텀 구분자를 포함하면 커스텀 구분자를 반환한다`() {
        // given
        val stringParser = StringParser()
        val input1 = "//;\n1;2;3"
        val input2 = "//!\n1!2!3"
        val input3 = "//@\n1@2@3"

        // when
        val parsingData1 = stringParser.parseDelimiter(input1)
        val parsingData2 = stringParser.parseDelimiter(input2)
        val parsingData3 = stringParser.parseDelimiter(input3)

        // then
        assertAll(
            { assertThat(parsingData1.delimiter).isEqualTo(";") },
            { assertThat(parsingData1.data).isEqualTo("1;2;3") },
            { assertThat(parsingData2.delimiter).isEqualTo("!") },
            { assertThat(parsingData2.data).isEqualTo("1!2!3") },
            { assertThat(parsingData3.delimiter).isEqualTo("@") },
            { assertThat(parsingData3.data).isEqualTo("1@2@3") }
        )
    }
}
