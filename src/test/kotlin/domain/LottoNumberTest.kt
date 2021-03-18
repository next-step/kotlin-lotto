package domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class LottoNumberTest {
    @Test
    fun `로또숫자는 정수를 입력받아 생성한다`() {
        assertDoesNotThrow { LottoNumber(1) }
    }
}
