package stringAddCalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.RuntimeException

class StringAddCalulatorTest {

    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator()
    }

    @ParameterizedTest
    @NullAndEmptySource()
    fun `빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다`(text: String?) {
        Assertions.assertThat(calculator.add(text)).isZero()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String?) {
        Assertions.assertThat(calculator.add(text)).isSameAs(text?.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun `숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`(text: String?) {
        Assertions.assertThat(calculator.add(text)).isSameAs(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun `문자열 앞부분의 문자를 커스텀 구분자를 지정할 수 있다`(text: String?) {
        Assertions.assertThat(calculator.add(text)).isSameAs(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2,3:4"])
    fun `커스텀 구분자를 가져도 기본 구분자와 병행해서 사용가능하다`(text: String?) {
        Assertions.assertThat(calculator.add(text)).isSameAs(10)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1,2,3"])
    fun `구분자, 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다`(text: String?) {
        assertThrows<RuntimeException> { calculator.add(text) }
    }
}
