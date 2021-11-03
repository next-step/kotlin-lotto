package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {

    @ParameterizedTest(name = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @NullAndEmptySource
    fun emptyOrNull(text: String?) {
        assertThat(StringAddCalculator.add(text)).isZero
    }

    @ParameterizedTest(name = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ValueSource(strings = ["1", "2", "3"])
    fun oneNumber(text: String) {
        assertThat(StringAddCalculator.add(text)).isSameAs(Integer.parseInt(text))
    }

    @ParameterizedTest(name = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ValueSource(strings = ["1,2", "3,4", "5,6"])
    fun twoNumbers(text: String) {
        assertThat(StringAddCalculator.add(text)).isSameAs(3)
    }

    @ParameterizedTest(name = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ValueSource(strings = ["1,2:3", "4,5:6"])
    fun colons(text: String) {
        assertThat(StringAddCalculator.add(text)).isSameAs(6)
    }

    @ParameterizedTest(name = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ValueSource(strings = ["//;\n1;2;3"])
    fun customDelimiter(text: String) {
        assertThat(StringAddCalculator.add(text)).isSameAs(6)
    }

    @ParameterizedTest(name = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @ValueSource(strings = ["-1", "-2", "-3"])
    fun negative(value: String) {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { StringAddCalculator.add(value) }
    }
}
