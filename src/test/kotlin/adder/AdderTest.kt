package adder

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class AdderTest {
    @Test
    fun `올바른 문자열 입력에 대해 올바르게 계산한다`() {
        val input = "123,45:66,7"
        val adder = Adder()
        val expected = 123 + 45 + 66 + 7
        assertThat(adder.getSum(input)).isEqualTo(expected)
    }

    @Test
    fun `음수가 포함된 문자열 입력에 대해 RunTimeException이 발생한다`() {
        val input = "123,-45:66,7"
        val adder = Adder()
        assertThrows<RuntimeException> { adder.getSum(input) }
    }

    @Test
    fun `잘못된 문자가 포함된 문자열 입력에 대해 RunTimeException이 발생한다`() {
        val input = "123,@45:#,7"
        val adder = Adder()
        assertThrows<RuntimeException> { adder.getSum(input) }
    }
}
