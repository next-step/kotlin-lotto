package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringAddTokenizerTest {

    @DisplayName(value = "쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun defaultDelimiterTokens(text: String) {
        assertThat(StringAddTokenizer(text).getTokens()).isEqualTo(text.split(DEFAULT_DELIMITER_REGEX))
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun customDelimiter(text: String) {
        val result = FIND_CUSTOM_DELIMITER_REGEX.find(text)
        assertThat(result).isNotNull

        val customDelimiter = result!!.groupValues[1]
        assertThat(customDelimiter).isEqualTo(";")
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자로 가지는 문자열을 전달하는 경우 커스텀 구분자를 기준으로 분리한다.")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun customDelimiterTokens(text: String) {
        val result = FIND_CUSTOM_DELIMITER_REGEX.find(text)
        assertThat(result).isNotNull

        val customDelimiter = result!!.groupValues[1]
        assertThat(customDelimiter).isEqualTo(";")

        assertThat(StringAddTokenizer(text).getTokens()).isEqualTo(result.groupValues[2].split(customDelimiter))
    }

    companion object {
        private val DEFAULT_DELIMITER_REGEX: Regex = "[,|:]".toRegex()
        private val FIND_CUSTOM_DELIMITER_REGEX: Regex = "//(.)\n(.*)".toRegex()
    }
}
