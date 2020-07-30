import Calculator.Calculator
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class Test {
    @Test
    fun `모든 숫자값을 합`() {
        assertThat(Calculator.calculate(listOf(1, 2, 3))).isEqualTo(6)
    }

    @Test
    fun `입력값 null 및 empty 체크`() {
        assertThatThrownBy { Calculator.getNumbers(null) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { Calculator.getNumbers("") }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
