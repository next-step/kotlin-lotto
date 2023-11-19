package lottoAuto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinningLottoTest {

    @Test
    fun `주어진 로또 리스트와 당첨 로또를 비교하여 당첨 등수를 반환한다`() {
        // given
        val bonusLottoNumber = 8.toLottoNumber()
        val winningLotto = WinningLotto(
            winningLottoNumbers = (4..9).map { it.toLottoNumber() },
            bonusLottoNumber = bonusLottoNumber
        )
        val lottoList = listOf(
            Lotto((1..6).map { it.toLottoNumber() }),
            Lotto((4..9).map { it.toLottoNumber() }),
            Lotto((10..15).map { it.toLottoNumber() }),
            Lotto((3..8).map { it.toLottoNumber() })
        )

        // when
        val lottoRanks = winningLotto.rank(lottoList)

        // then
        assertEquals(LottoRank.FOURTH, lottoRanks.ranks[0])
        assertEquals(LottoRank.FIRST, lottoRanks.ranks[1])
        assertEquals(LottoRank.MISS, lottoRanks.ranks[2])
        assertEquals(LottoRank.BONUS, lottoRanks.ranks[3])
    }
}
