import Calculator.Calculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Test {
    @Test
    fun `모든 숫자값을 합하는 메소드`() {
        assertThat(Calculator.calculate(listOf(1, 2, 3))).isEqualTo(6)
    }
}
