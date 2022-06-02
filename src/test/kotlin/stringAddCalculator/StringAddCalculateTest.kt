package stringAddCalculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculateTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다`(text: String?) {
        val expected = 0
        assertThat(stringAddCalculate(text)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "10", "9999"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String) {
        val expected = text.toInt()
        assertThat(stringAddCalculate(text)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun `숫자 두개를 쉼표 구분자로 입력할 경우 두 숫자의 합을 반환한다`(text: String) {
        val expected = 3
        assertThat(stringAddCalculate(text)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun `구분자를 쉼표 이외에 콜론을 사용할 수 있다`(text: String) {
        val expected = 6
        assertThat(stringAddCalculate(text)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "//;\n1;2;3",
            "//;\n1,2:3",
            "//?\n1,2?3",
            "//-\n1-2,3",
            "//a\n1,2a3",
            "//|\n1|2:3",
        ]
    )
    fun `커스텀 구분자를 지정할 수 있다`(text: String) {
        val expected = 6
        assertThat(stringAddCalculate(text)).isSameAs(expected)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "-1",
            "1:-2",
            "1+2-3",
            "1:2;3",
            "//a\n1;2;3",
        ]
    )
    fun `문자열 계산기에 음수 또는 지정되지 않은 구분자를 전달하는 경우 RuntimeException 예외 처리를 한다`(text: String) {
        val exceptionClass = java.lang.RuntimeException::class.java
        Assertions.assertThatThrownBy { stringAddCalculate(text) }.isInstanceOf(exceptionClass)
    }
}
