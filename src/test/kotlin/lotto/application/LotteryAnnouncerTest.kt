package lotto.application

import lotto.domain.Lotteries
import lotto.domain.Lotto
import lotto.domain.Price
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.MapAssert
import org.junit.jupiter.api.Test

class LotteryAnnouncerTest {

    @Test
    fun `winning doesn't depend on the order of numbers`() {
        val lotteries = Lotteries(
            listOf(
                Lotto(2, 1, 3, 5, 4, 6),
                Lotto(11, 12, 13, 14, 15, 16),
                Lotto(21, 22, 23, 24, 25, 26)
            )
        )

        val winner = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7

        val result = LotteryAnnouncer.announce(winner, bonusNumber, lotteries)

        MapAssert(result).extractingByKey(Price.FIRST).isNotNull
    }

    @Test
    fun `winning 2nd price test`() {
        val lotteries = Lotteries(
            listOf(
                Lotto(2, 1, 3, 5, 4, 6),
                Lotto(2, 1, 3, 5, 4, 7),
                Lotto(11, 12, 13, 14, 15, 16),
                Lotto(21, 22, 23, 24, 25, 26)
            )
        )

        val winner = Lotto(setOf(1, 2, 3, 4, 5, 6))

        val bonusNumber = 7

        val result = LotteryAnnouncer.announce(winner, bonusNumber, lotteries)

        MapAssert(result).extractingByKey(Price.SECOND).isNotNull
    }

    @Test
    fun `earning rate test`() {
        val investment = 3000
        val lotteries = Lotteries(
            listOf(
                Lotto(2, 1, 3, 5, 4, 8),
                Lotto(11, 12, 13, 14, 15, 16),
                Lotto(21, 22, 23, 24, 25, 26)
            )
        )

        val winner = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 8
        val expected = 10000f

        val priceGroupedLotteries = LotteryAnnouncer.announce(winner, bonusNumber, lotteries)
        val result = LotteryAnnouncer.getEarningRate(investment, priceGroupedLotteries)

        assertThat(result).isEqualTo(expected)
    }
}
