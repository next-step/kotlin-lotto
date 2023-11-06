package me.parker.nextstep.kotlinlotto.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    @DisplayName(value = "빈 문자열 값을 입력할 경우 0을 반환해야 한다.(null 허용하지 않음)")
    @ParameterizedTest
    @EmptySource
    fun empty(text: String) {
        assertThat(StringCalculator.add(text)).isZero()
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1"])
    fun oneNumber(text: String) {
        assertThat(StringCalculator.add(text)).isSameAs(Integer.parseInt(text))
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun twoNumbers(text: String) {
        assertThat(StringCalculator.add(text)).isSameAs(3)
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun colons(text: String) {
        assertThat(StringCalculator.add(text)).isSameAs(6)
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun customDelimiter(text: String) {
        assertThat(StringCalculator.add(text)).isSameAs(6)
    }

    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @Test
    fun negative() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { StringCalculator.add("-1") }
    }
}
