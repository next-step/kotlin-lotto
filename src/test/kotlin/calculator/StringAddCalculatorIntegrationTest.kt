package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class StringAddCalculatorIntegrationTest {

    private val underTest = StringAddCalculator()

    @Test
    fun `계산기`() {
        val input = "1,2,3"
        val expected = 6

        val result = underTest.run(input)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `커스텀 계산기`() {
        val input = "//;\n1;2;3"
        val expected = 6

        val result = underTest.run(input)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `음수는 계산할 수 없다`() {
        val input = "1,2,-3"
        val expectedMessage = "양수만 허용합니다. value: -3"

        val result = assertThrows<RuntimeException> { underTest.run(input) }

        assertThat(result.message).isEqualTo(expectedMessage)
    }

    @Test
    fun `빈문자열을 입력하는 경우 0을 반환한다`() {
        val input = ""
        val expected = 0

        val result = underTest.run(input)

        assertThat(result).isEqualTo(expected)
    }
}
