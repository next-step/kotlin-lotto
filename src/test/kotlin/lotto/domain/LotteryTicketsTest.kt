package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LotteryTicketsTest {

    @Test
    fun `constructor`() {
        val lotteryTickets = LotteryTickets(14)
        Assertions.assertThat(lotteryTickets.lotteryTickets).hasSize(14)
    }

    @Test
    fun `calculateStatics`() {

    }
}
