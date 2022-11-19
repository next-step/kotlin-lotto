package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


internal class CalculatorTest {
    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUP() {
        calculator = Calculator()
    }

    @Test
    fun `빈 문자열이면 0을 반환한다`() {
        val actual = calculator.calculate("")

        assertThat(actual).isEqualTo(0)
    }
    @Test
    fun `null이면 0을 반환한다`() {
        val actual = calculator.calculate(null)

        assertThat(actual).isEqualTo(0)
    }


    @Test
    fun `숫자 하나를 입력할 경우 해당 숫자를 그대로 반환한다`(){
        val actual = calculator.calculate("5")

        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun `쉼표(,)를 가지는 문자열을 받아서 구분자를 기준으로 분리한 숫자의 합을 반환한다`(){
        val actual = calculator.calculate("2,3")

        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun `콜론을 가지는 문자열을 받아서 구분자를 기준으로 분리한 숫자의 합을 반환한다`() {
        val actual = calculator.calculate("2:3")

        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun `커스텀 구분자를 지정할 수 있다`(){
        val actual = calculator.calculate("//;\n2;3;4")

        assertThat(actual).isEqualTo(9)
    }
}
