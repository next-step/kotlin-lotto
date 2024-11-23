package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DelimiterExtractorTest {
    @DisplayName(value = "//와 \\n 문자 사이에 지정한 문자로 커스텀 구분자와 나머지 문자열을 구할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun customDelimiter(text: String) {
        val (customDelimiter, extractedText) = DelimiterExtractor.extractDelimiterAndText(text)
        assertThat(customDelimiter).isEqualTo(";")
        assertThat(extractedText).isEqualTo("1;2;3")
    }

    @DisplayName(value = "//와 \\n 문자와 지정한 문자가 없으면 null과 기존 문자열을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1;2;3"])
    fun notCustomDelimiter(text: String) {
        val (customDelimiter, extractedText) = DelimiterExtractor.extractDelimiterAndText(text)
        assertThat(customDelimiter).isEqualTo(null)
        assertThat(extractedText).isEqualTo("1;2;3")
    }
}
