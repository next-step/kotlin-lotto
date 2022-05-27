import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringAddCalculatorTest {

    val calculator: StringAddCalculator = StringAddCalculator

    @Test
    fun `빈 문자열 값을 입력할 경우 0을 반환해야 한다`() {
        assertThat(calculator.add("")).isZero
    }

    @Test
    fun `null 값을 입력할 경우 0을 반환해야 한다`() {
        assertThat(calculator.add(null)).isZero
    }

    @Test
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`() {
        assertThat(calculator.add("1")).isEqualTo(1)
    }

    @Test
    fun `숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`() {
        assertThat(calculator.add("1,2")).isEqualTo(3)
    }

    @Test
    fun `구분자를 쉼표 이외에 콜론을 사용할 수 있다`() {
        assertThat(calculator.add("1,2:3")).isEqualTo(6)
    }

    @Test
    fun `슬래쉬 두개와 개행 문자 사이에 커스텀 구분자를 지정할 수 있다`() {
        assertThat(calculator.add("//;\n1;2;3")).isEqualTo(6)
    }

    @Test
    fun `문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다`() {
        assertThrows<RuntimeException> { calculator.add("-1") }
    }
}
