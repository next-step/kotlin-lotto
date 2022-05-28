package lotto.application

import lotto.domain.Lotteries
import lotto.domain.Lotto
import lotto.domain.Price
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

        val winner = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val result = LotteryAnnouncer.announce(winner, lotteries)

        MapAssert(result).extractingByKey(Price.FIRST).isNotNull
    }
}
