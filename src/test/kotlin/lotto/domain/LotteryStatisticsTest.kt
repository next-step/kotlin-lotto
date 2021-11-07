package lotto.domain

import lotto.fixture.BonusBallFixture
import lotto.fixture.LotteriesFixture
import lotto.fixture.LotteryFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

class LotteryStatisticsTest {

    @Test
    fun `로또 통계를 생성할 수 있다`() {
        // given
        val lotteries = LotteriesFixture.LOTTERIES
        val winning = LotteryFixture.WINNING_LOTTERY
        val bonusBall = BonusBallFixture.BONUS_BALL

        // when
        val statistics = LotteryStatistics.of(lotteries, winning, bonusBall).values

        // then
        assertAll(
            { assertThat(statistics.containsKey(Ranking.FOURTH)) },
            { assertThat(statistics.containsKey(Ranking.FIFTH)) },
            { assertThat(statistics[Ranking.FOURTH]).isEqualTo(1) },
            { assertThat(statistics[Ranking.FIFTH]).isEqualTo(1) },
            { assertThat(statistics.size).isEqualTo(2) }
        )
    }

    @Test
    fun `총 당첨금을 계산할 수 있다`() {
        // given
        val lotteries = LotteriesFixture.LOTTERIES
        val winning = LotteryFixture.WINNING_LOTTERY
        val bonusBall = BonusBallFixture.BONUS_BALL
        val statistics = LotteryStatistics.of(lotteries, winning, bonusBall)

        // when
        val reward = statistics.calculate()

        // then
        assertThat(reward)
            .isEqualTo(Money.from(Ranking.FOURTH.reward.value.add(Ranking.FIFTH.reward.value)))
    }
}
