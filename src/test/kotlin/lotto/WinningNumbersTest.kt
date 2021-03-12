package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class WinningNumbersTest {
    @Test
    internal fun `당첨번호에 보너스 번호가 있다`() {
        assertDoesNotThrow {
            WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 6), bonusNumber = 7)
        }
    }
}
