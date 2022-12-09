package simulator.lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RanksTest {
    @Test
    fun `등수 목록으로부터 전체 상금과 수익률을 가져올 수 있다`() {
        val ranks = Ranks(listOf(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH))
        val expectedTotalMoney =
            Rank.FIRST.winningMoney + Rank.SECOND.winningMoney + Rank.THIRD.winningMoney + Rank.FOURTH.winningMoney

        assertThat(ranks.totalMoney()).isEqualTo(expectedTotalMoney)
        assertThat(ranks.yield(10000)).isEqualTo(expectedTotalMoney.toDouble() / 10000)
    }

    @Test
    fun `등수 목록에서 랭크별 갯수를 알 수 있다`() {
        val ranks = Ranks(listOf(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH))

        assertThat(ranks.rankCount(Rank.FIRST)).isEqualTo(1)
        assertThat(ranks.rankCount(Rank.SECOND)).isEqualTo(1)
        assertThat(ranks.rankCount(Rank.THIRD)).isEqualTo(1)
        assertThat(ranks.rankCount(Rank.FOURTH)).isEqualTo(1)
        assertThat(ranks.rankCount(Rank.FIFTH)).isEqualTo(1)
    }

    @Test
    fun `당첨번호를 통해 로또 목록으로 부터 등수 목록을 생성할 수 있다`() {
        val firstLotto = Lotto(Numbers.of(listOf(1, 2, 3, 4, 5, 6)))
        val secondLotto = Lotto(Numbers.of(listOf(1, 2, 3, 4, 5, 7)))
        val thirdLotto = Lotto(Numbers.of(listOf(1, 2, 3, 4, 5, 8)))

        val lottoList = listOf(firstLotto, secondLotto, thirdLotto)
        val winningNumbers = WinningNumber(Numbers.of(listOf(1, 2, 3, 4, 5, 6)), Number(7))
        val rankList = Ranks.match(lottoList, winningNumbers)

        assertThat(rankList.rankCount(Rank.FIRST)).isEqualTo(1)
        assertThat(rankList.rankCount(Rank.SECOND)).isEqualTo(1)
        assertThat(rankList.rankCount(Rank.THIRD)).isEqualTo(1)

        val totalMoney =
            Rank.FIRST.winningMoney + Rank.SECOND.winningMoney + Rank.THIRD.winningMoney

        assertThat(rankList.totalMoney()).isEqualTo(totalMoney)
    }
}
