package lotto.model

import lotto.LottoAllTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class WinningCalculatorTest {
    @Test
    fun `당첨 통계를 계산한다`() {
        var test1Ticket = RandomLottoTicketGenerator()
        val test1WinningNumber = test1Ticket.lottoNumbers.toString().replace("[", "").replace("]", "")

        var test2Ticket = RandomLottoTicketGenerator()
        var test2WinningNumber = test2Ticket.lottoNumbers.toString().replace("[", "").replace("]", "")

        val testTickets = listOf(test1Ticket, test2Ticket)

        assertAll(
            {
                val testCalculator = WinningCalculator(testTickets, LottoTicket(test1WinningNumber), 1)
                assertEquals(
                    (LottoAllTest.LOTTO_MAX_REWARD / (testTickets.size * LottoAllTest.LOTTO_TICKET_PRICE)).toDouble(),
                    testCalculator.calculateRate(testTickets.size)
                )
            },
            {
                val testCalculator = WinningCalculator(testTickets, LottoTicket(test2WinningNumber), 1)
                assertEquals(
                    (LottoAllTest.LOTTO_MAX_REWARD / (testTickets.size * LottoAllTest.LOTTO_TICKET_PRICE)).toDouble(),
                    testCalculator.calculateRate(testTickets.size)
                )
            }
        )
    }

    companion object {
        const val LOTTO_MAX_REWARD = 2000000000
        const val LOTTO_TICKET_PRICE = 1000
    }
}
