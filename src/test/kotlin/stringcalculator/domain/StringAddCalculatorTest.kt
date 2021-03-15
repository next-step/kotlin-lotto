package stringcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringAddCalculatorTest {
    @Test
    internal fun `토큰의 모든 합을 반환한다`() {
        val tokens1 = Tokens.from(listOf("1", "2", "3"))
        val tokens2 = Tokens.from(listOf("3", "3", "3"))
        val tokens3 = Tokens.from(listOf("50", "40", "10"))

        assertThat(StringAddCalculator.calculate(tokens1)).isEqualTo(6)
        assertThat(StringAddCalculator.calculate(tokens2)).isEqualTo(9)
        assertThat(StringAddCalculator.calculate(tokens3)).isEqualTo(100)
    }
}
