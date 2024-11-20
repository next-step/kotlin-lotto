package calulator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumbersTest {
    @Test
    fun `음수가 포함된 경우 RuntimeException 이 발생한다`() {
        assertThrows<RuntimeException> {
            Numbers(listOf(1, -2, 3))
        }
    }

    @Test
    fun `sum 메서드가 합을 구한다`() {
        val numbers = Numbers(listOf(1, 2, 3))
        assertThat(numbers.sum).isEqualTo(6)
    }
}
