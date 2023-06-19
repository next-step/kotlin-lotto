package calculator.utils

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TextSplitterTest {
    @DisplayName(value = "문자열 계산기의 extractCustomDelimiter 함수가 string 을 delimiter 를 이용하여 토큰으로 분리한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2:3:4,5"])
    fun splitText(text: String) {
        Assertions.assertThat(TextSplitter.splitText(text, listOf(":", ","))).isEqualTo(listOf("1", "2", "3", "4", "5"))
    }
}
