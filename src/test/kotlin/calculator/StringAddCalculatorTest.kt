package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    @DisplayName("공백 문자열 또는 null을 입력할 경우 0을 반환한다")
    @ParameterizedTest
    @NullSource @ValueSource(strings = ["", " "])
    fun blankOrNull(text: String?) {
        val actual = StringAddCalculator.add(text)

        assertThat(actual).isEqualTo(0)
    }
}
