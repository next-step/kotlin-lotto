package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
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
}
