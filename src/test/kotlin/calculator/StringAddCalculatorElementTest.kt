package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorElementTest {

    @DisplayName("문자를 숫자로 변환한다.")
    @Test
    fun of() {
        // given
        val text = "1"

        // when
        val element = StringAddCalculatorElement.of(text)

        // then
        assertThat(element.number).isEqualTo(1)
    }

    @DisplayName("숫자가 아닌 경우 예외 처리를 한다.")
    @ParameterizedTest
    @ValueSource(strings = ["a", " ", "1a"])
    fun notNumber(text: String) {
        // given

        // when & then
        assertThatThrownBy { StringAddCalculatorElement.of(text) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자가 아닙니다.")
    }

    @DisplayName("음수인 경우 예외 처리를 한다")
    @Test
    fun negative() {
        // given

        // when & then
        assertThatThrownBy { StringAddCalculatorElement.of("-1") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("음수는 입력할 수 없습니다.")
    }
}
