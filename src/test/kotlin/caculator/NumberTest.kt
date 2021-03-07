package caculator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class NumberTest {

    @Test
    fun `Number은 음수일 수 없다`() {
        assertThrows<IllegalArgumentException>("number must be positive") {
            Number(-1)
        }
    }
}
