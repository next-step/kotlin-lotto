package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
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

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    @Test
    fun oneNumber() {
        val text = "1"

        val actual = StringAddCalculator.add(text)

        assertThat(actual).isEqualTo(1)
    }

    @DisplayName("쉼표 또는 콜론을 구분자로 가지는 문자열을 입력하면 구분자를 기준으로 분리한 숫자의 합을 반환한다")
    @Test
    fun delimiter() {
        val text = "1,2:3"

        val actual = StringAddCalculator.add(text)

        assertThat(actual).isEqualTo(6)
    }
}
