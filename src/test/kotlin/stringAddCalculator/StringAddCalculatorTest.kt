package stringAddCalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    private val calculator = StringAddCalculator()

    @ParameterizedTest
    @ValueSource(strings = [""])
    fun `빈 문자열을 입력할 경우 0을 반환해야 한다`(text: String) {
        assertThat(calculator.add(text)).isEqualTo(0)
    }

    @Test
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`() {
        TODO("Not yet implemented")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun `쉼표로 구분된 문자열을 더한 값을 리턴한다`(text: String) {
        assertThat(calculator.add(text)).isSameAs(3)
    }

    @Test
    fun `구분자를 컴마 이외에 콜론을 사용할 수 있다`() {
        TODO("Not yet implemented")
    }

    @Test
    fun `커스텀 구분자를 지정할 수 있다`() {
        TODO("Not yet implemented")
    }

    @Test
    fun `음수를 전달할 경우 RuntimeException 예외가 발생해야 한다`() {
        TODO("Not yet implemented")
    }
}
