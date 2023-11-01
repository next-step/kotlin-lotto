package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringParserTest {

    @ParameterizedTest
    @CsvSource(value = ["1,2,3:,:1,2,3", "34;43;43:;:34,43,43", "1!2!3:!:1,2,3"], delimiter = ':')
    fun `특정 구분자로 문자열을 파싱한다`(input: String, delimiter: String, expected: String) {
        // given
        val stringParser = StringParser()

        // when
        val result = stringParser.parse(input, delimiter)

        // then
        val expect = expected.split(',').map { it.toInt() }
        assertThat(result).containsAll(expect)
    }
}
