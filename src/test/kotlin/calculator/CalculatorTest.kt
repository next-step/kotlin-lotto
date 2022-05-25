package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CalculatorTest {

    @Test
    fun `입력 값이 빈스트링인 경우 0 확인`() {
        assertThat(Calculator.calculate("")).isEqualTo(0)
    }

    @Test
    fun `입력 값이 쉼표로 구분된 스트링인 1,2 경우합 확인`() {
        assertThat(Calculator.calculate("1,2")).isEqualTo(3)
    }

    @Test
    fun `입력 값이 콜론으로 구분된 스트링인 1,2 경우 합 확인`() {
        assertThat(Calculator.calculate("1:2")).isEqualTo(3)
    }

    @Test
    fun `입력 값이 쉼표 또는 콜론으로 구분된 스트링인 합 확인`() {
        assertThat(Calculator.calculate("1,2:3")).isEqualTo(6)
    }

    @Test
    fun `커스텀 구분자를 이용한 합 확인`() {
        assertThat(Calculator.calculate("//;\n1;2;3")).isEqualTo(6)
        assertThat(Calculator.calculate("//@\n1@2@3")).isEqualTo(6)
    }

    @Test
    fun `문자가 포함된 Input 값 RuntimeException 확인`() {
        assertThrows<RuntimeException> { Calculator.calculate("1,2:a") }
    }

    @Test
    fun `음수가 포함된 Input 값 RuntimeException 확인`() {
        assertThrows<RuntimeException> { Calculator.calculate("1,2:-3") }
    }

    @Test
    fun `커스텀 구분자에 음수값이 포함된 Input 값 RuntimeException 확인`() {
        assertThrows<RuntimeException> { Calculator.calculate("//;\n1;2;-3") }
    }

    @Test
    fun `커스텀 구분자에 문자가 포함된 Input 값 RuntimeException 확인`() {
        assertThrows<RuntimeException> { Calculator.calculate("//;\n1;2;a") }
    }
}
