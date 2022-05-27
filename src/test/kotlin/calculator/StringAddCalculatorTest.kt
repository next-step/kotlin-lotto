package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.RuntimeException

class StringAddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 을 입력할 경우 0 을 반환한다`(input: String?) {
        assertThat(StringAddCalculator.add(input)).isZero
    }

    @Test
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`() {
        assertThat(StringAddCalculator.add("3")).isEqualTo(3)
    }

    @Test
    fun `쉼표 구분자로 입력할 경우 두 숫자의 합을 반환한다`() {
        assertThat(StringAddCalculator.add("3,5")).isEqualTo(8)
    }

    @Test
    fun `콜론 구분자로 입력할 경우 두 숫자의 합을 반환한다`() {
        assertThat(StringAddCalculator.add("3:5")).isEqualTo(8)
    }

    @Test
    fun `쉽표, 콜론 구분자를 같이 입력할 경우에도 모든 숫자의 합을 반환하다`() {
        assertThat(StringAddCalculator.add("1,2:3")).isEqualTo(6)
    }

    @Test
    fun `커스텀 구분자를 지정할 수 있고 커스텀 구분자로 구분 된 숫자의 합을 반환한다`() {
        assertThat(StringAddCalculator.add("//!\n1!2!3")).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-1,2", "1:-2", "//!\n1!-2"])
    fun `음수를 전달 할 경우 RuntimeException 이 발생한다`(input: String) {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { StringAddCalculator.add(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a,2:3", "//!\n1!a"])
    fun `숫자가 아닌 문자열이 입력될 경우 RuntimeException 이 발생한다`(input: String) {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { StringAddCalculator.add(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1+2", "//+\n1&2"])
    fun `지정한 구분자 외의 다른 구분자를 사용하면 RuntimeException 이 발생한다`(input: String) {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { StringAddCalculator.add(input) }
    }
}
