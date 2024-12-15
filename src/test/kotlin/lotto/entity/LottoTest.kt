package lotto.entity

import lotto.domain.LottoNumber
import lotto.domain.WinningLottoNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `당첨 번호와 보너스 번호를 비교하여 매칭 결과를 반환`() {
        val lottoNumber = LottoNumber(setOf(1, 2, 3, 4, 5, 6))
        val lotto = Lotto(lottoNumber)

        val winningNumbers = LottoNumber(setOf(1, 2, 3, 7, 8, 9))
        val winningLottoNumber = WinningLottoNumber(winningNumbers, 6)

        val result = lotto.compareWithWinningNumbers(winningLottoNumber)

        assertEquals(3, result.matchCount)
        assertTrue(result.hasBonus)
    }
}
