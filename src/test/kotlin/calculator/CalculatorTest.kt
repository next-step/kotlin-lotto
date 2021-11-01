package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class CalculatorTest {

    private val calculator = Calculator

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다`(text: String?) {
        // when
        val result = calculator.add(text)

        // then
        assertThat(result).isZero
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "1"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String) {
        // when
        val result = calculator.add(text)

        // then
        assertThat(result).isSameAs(text.toInt())
    }

    @Test
    fun `숫자 두개를 쉼표 구분자로 입력할 경우 두 숫자의 합을 반환한다`() {
        // given
        val text = "1,2"

        // when
        val result = calculator.add(text)

        // then
        assertThat(result).isSameAs(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3", "1:2,3", "1:2:3"])
    fun `구분자를 쉼표 이외에 콜론을 사용할 수 있다`(text: String) {
        // when
        val result = calculator.add(text)

        // then
        assertThat(result).isSameAs(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3", "//;\n1,2;3", "//;\n1;2:3"])
    fun `두개의 슬래시문자와 개행문자 사이에 커스텀 구분자를 지정할 수 있다`(text: String) {
        // when
        val result = calculator.add(text)

        // then
        assertThat(result).isSameAs(6)
    }

    @Test
    fun `문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다`() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { calculator.add("-1") }
    }
}
