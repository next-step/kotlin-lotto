package autolotto.domain

import autolotto.entity.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoNumberTest {
    @Test
    fun `보너스 번호가 1~45 범위 초과시 예외 발생`() {
        val winningNumbers = LottoNumber(setOf(1, 2, 3, 4, 5, 6))
        val exception =
            assertThrows<IllegalArgumentException> {
                WinningLottoNumber(winningNumbers, 46)
            }
        assertEquals("보너스 번호는 1~45 사이여야 합니다.", exception.message)
    }

    @Test
    fun `보너스 번호가 당첨 번호와 겹치면 예외 발생`() {
        val winningNumbers = LottoNumber(setOf(1, 2, 3, 4, 5, 6))
        val exception =
            assertThrows<IllegalArgumentException> {
                WinningLottoNumber(winningNumbers, 6)
            }
        assertEquals("보너스 번호는 당첨 번호와 달라야 합니다.", exception.message)
    }

    @Test
    fun `당첨범호 포함여부 확인`() {
        val winningNumbers = LottoNumber(setOf(1, 2, 3, 4, 5, 6))
        val winningLottoNumber = WinningLottoNumber(winningNumbers, 7)

        assertTrue(winningLottoNumber.hasWinningNumber(3))
    }

    @Test
    fun `보너스번호 포함 여부 확인`() {
        val winningNumbers = LottoNumber(setOf(1, 2, 3, 4, 5, 6))
        val winningLottoNumber = WinningLottoNumber(winningNumbers, 7)

        val lotto = Lotto(LottoNumber(setOf(7, 8, 9, 10, 11, 12)))
        assertTrue(winningLottoNumber.hasBonusNumber(lotto))
    }
}
