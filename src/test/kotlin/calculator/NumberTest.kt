package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NumberTest {

    @Test
    fun `숫자로 Number 생성할 수 있다`() {
        val input: Int = 1
        val expected: Number = Number(1)
        val result: Number = Number(input)

        assertThat(result).isEqualTo(expected)
    }
    
    @Test
    fun `문자열로 Number 생성할 수 있다`() {
        val input: String = "1"
        val expected: Number = Number(1)
        val result: Number = Number(input)

        assertThat(result).isEqualTo(expected)
    }
}
