package lottery.domain

import fixture.LotteryFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RankCountsTest {
    @Test
    fun `맞춘 개수에 맞는 등수에 건수를 증가시킨다`() {
        val rankCounts = createRankCounts()

        assertAll(
            { assertThat(rankCounts.rankCounts[Rank.FIRST]).isEqualTo(2) },
            { assertThat(rankCounts.rankCounts[Rank.THIRD]).isEqualTo(1) },
            { assertThat(rankCounts.rankCounts[Rank.FOURTH]).isEqualTo(1) }
        )
    }

    @Test
    fun `모든 등수의 당첨금들 합을 가져온다`() {
        val rankCounts = createRankCounts()

        val amount = rankCounts.calculateJackpots()

        assertThat(amount).isEqualTo((Rank.FIRST.price * 2) + Rank.THIRD.price + Rank.FOURTH.price)
    }

    @Test
    fun `로또번호들 중에 당첨번호와 일치하는 개수들을 전달한다`() {
        val matchCounts = createRankCounts()

        assertAll(
            { assertThat(matchCounts.retrieve(Rank.FOURTH)).isEqualTo(1) },
            { assertThat(matchCounts.retrieve(Rank.THIRD)).isEqualTo(1) },
            { assertThat(matchCounts.retrieve(Rank.FIRST)).isEqualTo(2) }
        )
    }

    private fun createLottery(numbers: List<Int>) = Lottery(LotteryNumbers(numbers))

    private fun createRankCounts(): RankCounts {
        val lotteries = listOf(
            createLottery(listOf(1, 3, 5, 2, 9, 40)),
            createLottery(listOf(34, 24, 1, 15, 3, 5)),
            createLottery(listOf(3, 1, 5, 15, 24, 40)),
            createLottery(listOf(1, 3, 5, 40, 24, 15))
        )

        val winnerLottery = WinnerLottery(listOf(1, 3, 5, 24, 15, 40), LotteryFixture.TEST_BONUS_BALL)

        return RankCounts(lotteries, winnerLottery)
    }
}
