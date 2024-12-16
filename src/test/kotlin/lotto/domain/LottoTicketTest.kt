package lotto.domain

import io.kotest.matchers.shouldBe
import lotto.domain.LottoResultTest.Companion.makeLottoTicket
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `생성 확인`() {
        val tickets =
            LottoTicket.generateLottoTickets(1) {
                listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }
            }

        val winner = makeLottoTicket(1, 2, 3, 4, 5, 6)
        winner.correctNumberCount(tickets[0]) shouldBe 6
    }

    @Test
    fun `1등 확인`() {
        val ticket = makeLottoTicket(1, 2, 3, 4, 5, 6)
        val winner = makeLottoTicket(1, 2, 3, 4, 5, 6)
        winner.correctNumberCount(ticket) shouldBe 6
    }

    @Test
    fun `3등 확인`() {
        val ticket = makeLottoTicket(1, 2, 3, 4, 7, 8)
        val winner = makeLottoTicket(1, 2, 3, 4, 5, 6)
        winner.correctNumberCount(ticket) shouldBe 4
    }
}
