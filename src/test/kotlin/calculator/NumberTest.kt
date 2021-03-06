package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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

    @Test
    fun `숫자가 아닌 문자열로 Number를 생성하는 경우 예외를 반환한다`() {
        val input: String = "z"
        val expectedMessage: String = "허용하지 않는 문자열입니다. value: $input"
        val result: IllegalArgumentException = assertThrows { Number(input) }

        assertThat(result.message).isEqualTo(expectedMessage)
    }
}
