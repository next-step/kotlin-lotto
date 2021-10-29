package calculator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PositiveNumberTest {

    @Test
    fun `분리된 숫자는 0보다 작은 값으로 초기화 하면 RuntimeException 예외가 밝생한다`() {
        assertThrows<RuntimeException> { PositiveNumber(-1) }
    }
}
