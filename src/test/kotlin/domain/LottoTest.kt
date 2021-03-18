package domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class LottoTest {
    @Test
    fun `로또는 로또숫자열 하나로 생성된다`() {
        assertDoesNotThrow { Lotto(LottoNumbers(1, 2, 3, 4, 5, 6)) }
    }

    @Test
    fun `로또는 숫자 6개로도 생성된다`() {
        assertDoesNotThrow {
            Lotto(listOf(1, 2, 3, 4, 5, 6))
            Lotto(1, 2, 3, 4, 5, 6)
        }
    }
}
