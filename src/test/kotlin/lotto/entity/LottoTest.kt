package lotto.entity

import lotto.domain.LottoNumber
import lotto.domain.WinningLottoNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `당첨 번호와 보너스 번호를 비교하여 매칭 결과를 반환`() {
        val lottoNumber = LottoNumber(setOf(1, 2, 3, 4, 5, 6))
        val lotto = Lotto(mutableListOf(lottoNumber), mutableListOf(lottoNumber))
        val winningNumbers = LottoNumber(setOf(1, 2, 3, 7, 8, 9))
        val winningLottoNumber = WinningLottoNumber(winningNumbers, 6)

        val result =
            lotto.getTotalLottoInfos().map { it.compareWithWinningNumbers(winningLottoNumber) }

        val matchCount = result.map { it.matchCount }.sum()

        assertEquals(6, matchCount)
    }
}
