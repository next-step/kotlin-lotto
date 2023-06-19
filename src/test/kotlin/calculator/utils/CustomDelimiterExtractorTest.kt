package calculator.utils

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CustomDelimiterExtractorTest {
    @DisplayName(value = "문자열 계산기의 extractCustomDelimiter 함수가 custom delimiter 를 분리한다")
    @ParameterizedTest
    @ValueSource(strings = ["//@\n1:2@4"])
    fun extractCustomDelimiter(text: String) {
        Assertions.assertThat(CustomDelimiterExtractor.extract(text)).isEqualTo(Pair("@", "1:2@4"))
    }
}
