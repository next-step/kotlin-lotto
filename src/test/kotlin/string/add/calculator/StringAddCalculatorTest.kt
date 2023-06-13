package string.add.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator()
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다`(text: String?) {
        assertThat(calculator.add(text)).isZero()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String) {
        assertThat(calculator.add(text)).isSameAs(Integer.parseInt(text))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun `숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`(text: String) {
        assertThat(calculator.add(text)).isSameAs(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun `구분자를 쉼표 이외에 콜론을 사용할 수 있다`(text: String) {
        assertThat(calculator.add(text)).isSameAs(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3", "//;\n1,2;3"])
    fun `커스텀 구분자를 지정할 수 있다`(text: String) {
        assertThat(calculator.add(text)).isSameAs(6)
    }

    @Test
    fun `문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다`() {
        assertThrows<RuntimeException> {
            calculator.add("-1")
        }
    }
}
