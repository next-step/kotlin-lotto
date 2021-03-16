package lotto.result

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WinningResultTest {

    @Test
    fun `받은 상금의 총 상금을 계산한다`() {
        //given
        val prizes = listOf(PrizeRank.FOURTH, PrizeRank.FIRST)

        //when
        val result = WinningResult.aggregate(prizeRanks = prizes)

        //then
        assertThat(result.totalPrize).isEqualTo(prizes.map { it.prizeAmount }.reduce{x,y->x+y})
    }

    @Test
    fun `받은 상금을 통계표로 조회가능하다`() {
        //given
        val prizes = listOf(PrizeRank.FOURTH, PrizeRank.FIRST, PrizeRank.FIRST, PrizeRank.THIRD)

        //when
        val result = WinningResult.aggregate(prizeRanks = prizes)

        //then
        assertThat(result.getPrize(PrizeRank.FIRST)).isEqualTo(2)
        assertThat(result.getPrize(PrizeRank.SECOND)).isEqualTo(0)
        assertThat(result.getPrize(PrizeRank.THIRD)).isEqualTo(1)
        assertThat(result.getPrize(PrizeRank.FOURTH)).isEqualTo(1)
        assertThat(result.getPrize(PrizeRank.FAIL)).isEqualTo(0)
    }
}