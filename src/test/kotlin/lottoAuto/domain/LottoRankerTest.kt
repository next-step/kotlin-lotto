package lottoAuto.domain

import lottoAuto.domain.LottoNumber.Companion.toLottoNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoRankerTest {
    @Test
    fun `주어진 로또 리스트와 당첨 로또를 비교하여 당첨 등수를 반환한다`() {
        // given
        val lottoNumbers1 = (1..6).map { it.toLottoNumber() }
        val lottoNumbers2 = (4..9).map { it.toLottoNumber() }
        val lottoNumbers3 = (10..15).map { it.toLottoNumber() }
        val winningLottoNumbers = (4..9).map { it.toLottoNumber() }

        // when
        val lottoRanks = LottoRanker.rank(
            listOf(
                Lotto(lottoNumbers1),
                Lotto(lottoNumbers2),
                Lotto(lottoNumbers3)
            ),
            WinningLotto(winningLottoNumbers)
        )

        // then
        assertEquals(LottoRank.FOURTH, lottoRanks.ranks[0])
        assertEquals(LottoRank.FIRST, lottoRanks.ranks[1])
        assertEquals(LottoRank.MISS, lottoRanks.ranks[2])
    }
}
