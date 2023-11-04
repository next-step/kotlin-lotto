package stringaddcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null을 입력하면 0을 반환한다`(input: String?) {
        assertThat(calculator.calculate(input)).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(input: String) {
        assertThat(calculator.calculate(input)).isEqualTo(input.toInt())
    }

    @Test
    fun `숫자 두개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환한다`() {
        assertThat(calculator.calculate("1,2")).isEqualTo(3)
    }

    @Test
    fun `숫자 두개를 콜론 구분자로 입력할 경우 두 숫자의 합을 반환한다`() {
        assertThat(calculator.calculate("1:2")).isEqualTo(3)
    }

    @Test
    fun `구분자를 컴마와 콜론을 사용할 수 있다`() {
        assertThat(calculator.calculate("1:2,3")).isEqualTo(6)
    }

    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다")
    @Test
    fun `커스텀 구분자를 지정할 수 있다`() {
        assertThat(calculator.calculate("//;\n1;2;3")).isEqualTo(6)
    }

    @Test
    fun `음수를 전달할 경우 RuntimeException 발생한다`() {
        assertThrows<RuntimeException> { (calculator.calculate("-1,2,3")) }
    }

    @Test
    fun `숫자 이외의 값을 전달할 경우 RuntimeException 발생한다`() {
        assertThrows<RuntimeException> { (calculator.calculate("1,a,3")) }
    }

    @Test
    fun `커스터 구분자가 -인 경우에도 계산이 된다`() {
        assertThat(calculator.calculate("//-\n1-2-3")).isEqualTo(6)
    }
}
