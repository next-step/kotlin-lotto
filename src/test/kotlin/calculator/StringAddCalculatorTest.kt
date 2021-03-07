package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

internal class StringAddCalculatorIntegrationTest {

    private val underTest = StringAddCalculator()
    
    @Test
    fun `계산기`() {
        val input = "1,2,3"
        val expected = 6

        val result = underTest.calculate(input)

        assertThat(result).isEqualTo(expected)
    }
    
    @Test
    fun `커스텀 계산기`() {
        val input = "//;\n1;2;3"
        val expected = 6

        val result = underTest.calculate(input)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `음수는 계산할 수 없다`() {
        val input = "1,2,-3"
        val expectedMessage = "양수만 허용합니다. value: -3"

        val result = assertThrows<IllegalArgumentException> { underTest.calculate(input) }
        
        assertThat(result.message).isEqualTo(expectedMessage)
    }
}
