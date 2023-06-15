package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    fun `빈 문자열, null 입력 시 0 반환`() {
        val calculator = StringCalculator()
        val emptyDummy = ""
        val nullDummy = null

        assertThat(calculator.calculate(emptyDummy)).isEqualTo(0)
        assertThat(calculator.calculate(nullDummy)).isEqualTo(0)
    }
}
