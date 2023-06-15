package calculator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    fun `빈 문자열, null 입력 시 0 반환`() {
        val calculator = StringCalculator()
        val emptyDummy = ""
        val nullDummy = null

        assertThat(calculator.calculate(emptyDummy)).isEqualTo(0)
        assertThat(calculator.calculate(nullDummy)).isEqualTo(0)
    }

    @Test
    fun `숫자 이외의 값 입력 시 RuntimeException throw`() {
        val calculator = StringCalculator()
        val inputExceptNumber = "a"

        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { calculator.calculate(inputExceptNumber) }
    }

    @Test
    fun `음수 입력 시 RuntimeException throw`() {
        val calculator = StringCalculator()
        val negativeNumber = "-1"

        assertThatThrownBy {
            calculator.calculate(negativeNumber)
        }.isInstanceOf(RuntimeException::class.java)
    }

    @Test
    fun `숫자 하나가 전달될 경우 해당 숫자를 반환`() {
        val calculator = StringCalculator()
        val actualInput = "3"

        assertThat(calculator.calculate(actualInput)).isEqualTo(3)
    }

    @Test
    fun `쉼표, 콜론을 구분자로 가진 문자열이 전달될 경우 구분자를 기준으로 숫자의 합을 반환`() {
        val calculator = StringCalculator()
        val actualInput = "1,2:3"

        assertThat(calculator.calculate(actualInput)).isEqualTo(6)
    }

    @Test
    fun `커스텀 구분자를 지정해 숫자의 합을 반환할 수 있다`() {
        val calculator = StringCalculator()
        val actualInput = "//;\n1;2;3"

        assertThat(calculator.calculate(actualInput)).isEqualTo(6)
    }
}
