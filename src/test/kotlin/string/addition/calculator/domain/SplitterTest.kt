package string.addition.calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import string.addition.calculator.domain.Splitter.DEFAULT_NUMBER

internal class SplitterTest {
    @ParameterizedTest
    @ValueSource(strings = ["//*\\n", "//&@#\\n1,2,3,5", "//;\\n1;2;3;5"])
    @DisplayName("\"//\"와 \"\\n\" 사이에 위치하는 문자를 이용해서 문자열을 구분할 수 있다")
    fun customDelimiterTest(input: String) {
        val delimiters = Splitter.getDelimiters(input)
        assertThat(delimiters.size).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "   "])
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다`(input: String) {
        val numbers = Splitter.split(input, Splitter.getDelimiters(input))
        assertThat(numbers[0]).isEqualTo(DEFAULT_NUMBER)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(input: String) {
        val numbers = Splitter.split(input, Splitter.getDelimiters(input))
        assertThat(numbers[0]).isEqualTo(input)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "2,3:1", "//*\\n1*2:3"])
    fun `구분자로 입력할 경우 숫자 리스트를 반환한다`(input: String) {
        val numbers = Splitter.split(input, Splitter.getDelimiters(input))
        assertThat(numbers).contains("1", "2", "3")
    }
}
