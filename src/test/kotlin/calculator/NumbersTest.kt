package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumbersTest {

    @Test
    fun `음수의 값이 들어오면 RuntimeException 가 발생한다`() {
        assertThrows<RuntimeException> {
            Numbers(listOf(-1, -2, 4))
        }
    }

    @Test
    fun `숫자가 아닌 값이 들어오면 RuntimeException 가 발생한다`() {
        assertThrows<RuntimeException> {
            Numbers(listOf("a", "b", "c"))
        }
    }

    @Test
    fun `숫자의 합을 구한다`() {
        Assertions.assertThat(Numbers(listOf(1, 2, 3)).sum).isEqualTo(6)
    }
}
