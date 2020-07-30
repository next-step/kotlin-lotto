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

    @Test
    fun `커스텀 구분자 유무 확인`() {
        assertThat(Calculator.hasCustomSplitter("//x\n")).isEqualTo(true)
        assertThat(Calculator.hasCustomSplitter("/")).isEqualTo(false)
    }

    @Test
    fun `커스텀 구분자 얻기`() {
        assertThat(Calculator.getCustomSplitter("//x\n")).isEqualTo('x')
    }
}
