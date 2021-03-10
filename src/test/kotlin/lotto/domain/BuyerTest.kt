package lotto.domain

import lotto.domain.maker.TestLotteryTicketMaker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BuyerTest {

    @Test
    fun `로또를 구매한다`() {
        val buyer = Buyer()
        val tickets = buyer.buyLotteryTickets(2000, TestLotteryTicketMaker())

        assertThat(tickets).hasSize(2)
        assertThat(tickets[0].lottoNumbers).containsOnly(1, 2, 3, 4, 5, 6)
    }
}
