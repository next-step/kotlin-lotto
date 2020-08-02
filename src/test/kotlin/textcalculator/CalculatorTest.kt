package textcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `sum() 숫자 전부 합계를 낸다`() {
        assertThat(
            Calculator.sum(
                listOf(1, 2, 3, 4, 5)
            )
        ).isEqualTo(15)
    }
}
