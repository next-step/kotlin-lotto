package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoMatchListTest {

    val lottRankList: List<LottoRank> = LottoRank.getWinning()

    @Test
    fun `lottoMatchList의 개수는 LottoRank winning 리스트의 개수와 같다`() {
        val lottoMatchList = mutableListOf<LottoMatch>()
        lottoMatchList.add(LottoMatch(LottoRank.FIRST_PLACE, 1))
        lottoMatchList.add(LottoMatch(LottoRank.SECOND_PLACE, 2))

        val resultLottoMatchList = LottoMatchList(lottoMatchList)
        assertThat(resultLottoMatchList.lottoMatchList.count()).isEqualTo(lottRankList.count())
    }

    @Test
    fun `lottoMatchList는 LottoRank winning 리스트를 모두 포함한다`() {
        val lottoMatchList = mutableListOf<LottoMatch>()
        lottoMatchList.add(LottoMatch(LottoRank.FIRST_PLACE, 1))
        lottoMatchList.add(LottoMatch(LottoRank.SECOND_PLACE, 2))

        val resultLottoMatchList = LottoMatchList(lottoMatchList).lottoMatchList
        val resultLottoMatchListRank = resultLottoMatchList.map { it.lottoRank }

        assertThat(resultLottoMatchListRank).containsAll(lottRankList)
    }
}
