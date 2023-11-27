package lotto

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class BenefitCalculatorTest {
    
    @Test
    fun `14장 중에 4등 1장 미당첨 13장일 경우 수익률은 0,35이다`() {
        val calculator = BenefitCalculator()
        val result = mapOf(
            1 to 0,
            2 to 0,
            3 to 0,
            4 to 1,
            0 to 13
        )
        
        val actual = calculator.calculate(result)
        assertThat(actual).isEqualTo("0.35")
    }
}
