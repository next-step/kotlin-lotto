package calculate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DelimiterSetterTest {

    @DisplayName(value = "커스텀 구분자가 포함되어 있는 경우 커스텀 구분자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun customDelimiter(text: String) {
        assertThat(DelimiterSetter(text).delimiter).isEqualTo(listOf(";"))
    }
}
