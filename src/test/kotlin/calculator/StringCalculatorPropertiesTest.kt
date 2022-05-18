package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.RuntimeException

class StringCalculatorPropertiesTest {
    @Test
    fun `커스텀 구분자가 주어질 경우 CustomStringCalculatorProperties 를 반환한다`() {
        assertThat(StringCalculatorProperties.of("//&\n1&2")).isInstanceOf(CustomStringCalculatorProperties::class.java)
    }

    @Test
    fun `커스텀 구분자가 주어지지 않을 경우 DefaultStringCalculatorProperties 를 반환한다`() {
        assertThat(StringCalculatorProperties.of("1,2:3")).isInstanceOf(DefaultStringCalculatorProperties::class.java)
    }

    @Test
    fun `기본 구분자는 쉼표 또는 콜론이다`() {
        assertArrayEquals(arrayOf(",", ":"), DefaultStringCalculatorProperties("1,2").delimiters)
    }

    @Test
    fun `기본 구분자로 숫자를 구분할 수 있다`() {
        assertThat(StringCalculatorProperties.of("1,2:3").getPositiveInts()).isEqualTo(listOf(1, 2, 3))
    }

    @Test
    fun `커스텀 구분자로 숫자를 구분할 수 있다`() {
        assertThat(StringCalculatorProperties.of("//!\n1!2!3").getPositiveInts()).isEqualTo(listOf(1, 2, 3))
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-1,2", "1:-2", "//!\n1!-2"])
    fun `음수를 전달 할 경우 RuntimeException 이 발생한다`(input: String) {
        Assertions.assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { StringCalculatorProperties.of(input).getPositiveInts() }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "a,2"])
    fun `숫자가 아닌 문자열이 입력될 경우 RuntimeException 이 발생한다`(input: String) {
        Assertions.assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { StringCalculatorProperties.of(input).getPositiveInts() }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1+2", "//+\n1&2"])
    fun `지정한 구분자 외의 다른 구분자를 사용하면 RuntimeException 이 발생한다`(input: String) {
        Assertions.assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { StringCalculatorProperties.of(input).getPositiveInts() }
    }
}
