package step1

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @Test
    fun `쉼표 또는 콜론을 구분자로 가지는 문자열을 받는다`() {
        val sum = Calculator.sum("1,2")

        assertThat(sum).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3", "1:2,3"])
    fun `구분자를 쉼표 이외에 콜론을 사용할 수 있다`(input: String) {
        val sum = Calculator.sum(input)

        assertThat(sum).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(input: String) {
        val sum = Calculator.sum(input)

        assertThat(sum).isEqualTo(input.toInt())
    }

    @Test
    fun `쉼표 또는 콜론이 아닌 다른 구분자의 경우 오류를 발생한다`() {
        assertThatThrownBy { Calculator.sum("1&2") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `숫자 음수를 전달하는 경우 오류를 발생한다`() {
        assertThatThrownBy { Calculator.sum("1,-2") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `빈 값을 입력하면 0을 반환한다`() {
        val sum = Calculator.sum("")

        assertThat(sum).isEqualTo(0)
    }

    @Test
    fun `커스텀 구분자를 사용한다`() {
        val sum = Calculator.sum("//;\\n1;2;3")

        assertThat(sum).isEqualTo(6)
    }
}
