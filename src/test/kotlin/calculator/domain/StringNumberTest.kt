package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringNumberTest {

    @DisplayName(value = "문자열로 음수가 아닌 숫자를 전달하는 경우 숫자로 변환할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "100"])
    fun number(text: String) {
        assertThat(StringNumber(text).toInt()).isEqualTo(text.toInt())
    }

    @DisplayName(value = "문자열로 숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 throw 한다.")
    @ParameterizedTest
    @ValueSource(strings = ["a", "!", ";"])
    fun notNumber(text: String) {
        assertThatThrownBy {
            StringNumber(text)
        }.isInstanceOf(RuntimeException::class.java)
            .hasMessageMatching("숫자 이외의 값일 수 없습니다.")
    }

    @DisplayName(value = "문자열로 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.")
    @ParameterizedTest
    @ValueSource(strings = ["-1", "-100"])
    fun negative(text: String) {
        assertThatThrownBy {
            StringNumber(text)
        }.isInstanceOf(RuntimeException::class.java)
            .hasMessageMatching("숫자는 음수일 수 없습니다.")
    }
}
