package stringcalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SplitTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "1:2:3", "1,2:3", "1:2,3"])
    fun `주어진 문자열로부터 쉼표 또는 콜론을 구분자로 하여 문자열 리스트를 얻을 수 있다`(text: String) {
        val expected = listOf("1", "2", "3")
        Assertions.assertThat(split(text)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3", "//a\n1:2a3", "//-\n1-2,3", "//?\n1:2?3"])
    fun `쉼표,콜론 이외에 지정된 문자를 구분자로 하여 문자열 리스트를 얻을 수 있다`(text: String) {
        val expected = listOf("1", "2", "3")
        Assertions.assertThat(split(text)).isEqualTo(expected)
    }
}
