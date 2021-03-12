package vo

import calculator.vo.Token
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TokenTest {
    @Test
    internal fun `음수 예외 테스트`() {
        assertThrows<RuntimeException> {
            Token(-1)
        }
    }
}
