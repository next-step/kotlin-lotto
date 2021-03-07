package stringaddcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {

    private lateinit var calculator: Calculator

    @BeforeEach
    fun setup() {
        calculator = Calculator()
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 Null을 입력할 경우 0을 반환 한다`(text: String) {
        assertThat(calculator.add(text)).isZero()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String) {
        assertThat(calculator.add(text)).isSameAs(text?.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun `숫자 두개를 쉼표 구분자로 입력할 경우 두 숫자의 합을 반환한다`(text: String) {
        assertThat(calculator.add(text)).isSameAs(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun `구분자를 쉼표 이외에 콜론을 사용할 수 있다`(text: String) {
        assertThat(calculator.add(text)).isSameAs(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun `커스텀 구분자를 지정할 수 있다`(text: String) {
        assertThat(calculator.add(text)).isSameAs(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun `커스텀 구분자로 숫자를 구분하면 구분자로 분리한 숫자 리스트를 반환한다`(text: String) {
        calculator.parseExpression(text)?.let {
            assertThat(it.size).isEqualTo(3)
        }
    }
}
