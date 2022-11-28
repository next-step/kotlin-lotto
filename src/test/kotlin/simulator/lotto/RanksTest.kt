package simulator.lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RanksTest {
    @Test
    fun `랭크 목록으로부터 전체 상금과 수익률을 가져올 수 있다`() {
        val ranks = Ranks(listOf(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH))
        val expectedTotalMoney =
            Rank.FIRST.winningMoney + Rank.SECOND.winningMoney + Rank.THIRD.winningMoney + Rank.FOURTH.winningMoney

        assertThat(ranks.totalMoney()).isEqualTo(expectedTotalMoney)
        assertThat(ranks.yield(10000)).isEqualTo(expectedTotalMoney.toDouble() / 10000)
    }

    @Test
    fun `랭크 목록에서 랭크별 갯수를 알 수 있다`() {
        val ranks = Ranks(listOf(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH))

        assertThat(ranks.rankCount(Rank.FIRST)).isEqualTo(1)
        assertThat(ranks.rankCount(Rank.SECOND)).isEqualTo(1)
        assertThat(ranks.rankCount(Rank.THIRD)).isEqualTo(1)
        assertThat(ranks.rankCount(Rank.FOURTH)).isEqualTo(1)
        assertThat(ranks.rankCount(Rank.FIFTH)).isEqualTo(1)
    }
}
