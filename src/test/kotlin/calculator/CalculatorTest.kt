package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CalculatorTest {

    @Test
    fun `입력 값이 빈스트링인 경우 0의 원소를 갖는 List 반환`() {
        assertThat(Calculator.split("")).isEqualTo(listOf(0))
    }

    @Test
    fun `입력 값이 쉼표로 구분된 스트링인 경우 숫자 n개의 원소를 갖는 List 반환`() {
        assertThat(Calculator.split("1,2")).isEqualTo(listOf(1, 2))
    }

    @Test
    fun `입력 값이 콜론으로 구분된 스트링인 경우 숫자 n개의 원소를 갖는 List 반환`() {
        assertThat(Calculator.split("1:2")).isEqualTo(listOf(1, 2))
    }

    @Test
    fun `입력 값이 쉼표 또는 콜론으로 구분된 스트링인 경우 숫자 n개의 원소를 갖는 List 반환`() {
        assertThat(Calculator.split("1,2:3")).isEqualTo(listOf(1, 2, 3))
    }

    @Test
    fun `커스텀 구분자를 이용한 Split 확인`() {
        assertThat(Calculator.split("//;\n1;2;3")).isEqualTo(listOf(1, 2, 3))
        assertThat(Calculator.split("//@\n1@2@3")).isEqualTo(listOf(1, 2, 3))
    }

    @Test
    fun `문자가 포함된 Input 값 RuntimeException 확인`() {
        assertThrows<RuntimeException> { Calculator.split("1,2:a") }
    }

    @Test
    fun `음수가 포함된 Input 값 RuntimeException 확인`() {
        assertThrows<RuntimeException> { Calculator.split("1,2:-3") }
    }

    @Test
    fun `커스텀 구분자에 음수값이 포함된 Input 값 RuntimeException 확인`() {
        assertThrows<RuntimeException> { Calculator.split("//;\n1;2;-3") }
    }

    @Test
    fun `커스텀 구분자에 문자가 포함된 Input 값 RuntimeException 확인`() {
        assertThrows<RuntimeException> { Calculator.split("//;\n1;2;a") }
    }

    @Test
    fun `Calculator 기능 테스트`() {
        assertThat(Calculator.calculate("//@\n1@2@3")).isEqualTo(6)
        assertThat(Calculator.calculate("1,2:3:4")).isEqualTo(10)
    }
}
