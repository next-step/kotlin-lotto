package string.addition.calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import string.addition.calculator.domain.Splitter.CUSTOM_DELIMITER_PREFIX
import string.addition.calculator.domain.Splitter.CUSTOM_DELIMITER_SUFFIX
import string.addition.calculator.domain.Splitter.DEFAULT_NUMBER

internal class SplitterTest {
    @ParameterizedTest
    @ValueSource(strings = ["//*\\n", "//&@#\\n1,2,3,5", "//;\\n1;2;3;5"])
    fun `커스텀 구분자를 포함한 문자열을 입력받으면 구분자가 추가된다`(input: String) {
        val delimiters = Splitter.getDelimiters(input)
        assertThat(delimiters.size).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//*\\n", "//&@#\\n1,2,3,5", "//;\\n1;2;3;5"])
    fun `input을 정규화하면 커스텀 구분자가 제거된다`(input: String) {
        val normalizedInput = Splitter.normalizeForSplit(input, Splitter.getDelimiters(input))
        assertThat(normalizedInput).doesNotContain(CUSTOM_DELIMITER_PREFIX).doesNotContain(CUSTOM_DELIMITER_SUFFIX)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "   "])
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다`(input: String) {
        val numbers = Splitter.split(input)
        assertThat(numbers[0]).isEqualTo(DEFAULT_NUMBER)
    }
}
