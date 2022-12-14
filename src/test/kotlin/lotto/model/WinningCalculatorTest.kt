package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class WinningCalculatorTest {
    @Test
    fun `당첨 통계를 계산한다`() {
        var test1Ticket = LottoTicket()
        val test1WinningNumber = test1Ticket.lottoNumbers.toString().replace("[", "").replace("]", "")

        var test2Ticket = LottoTicket()
        var test2WinningNumber = test2Ticket.lottoNumbers.toString().replace("[", "").replace("]", "")

        val testTickets = listOf(test1Ticket, test2Ticket)

        assertAll(
            {
                val testCalculator = WinningCalculator(testTickets, WinnerNumber(test1WinningNumber))
                assertEquals(
                    (LOTTO_MAX_REWARD / (testTickets.size * LOTTO_TICKET_PRICE)).toDouble(),
                    testCalculator.calculateRate(testTickets.size)
                )
            },
            {
                val testCalculator = WinningCalculator(testTickets, WinnerNumber(test2WinningNumber))
                assertEquals(
                    (LOTTO_MAX_REWARD / (testTickets.size * LOTTO_TICKET_PRICE)).toDouble(),
                    testCalculator.calculateRate(testTickets.size)
                )
            },
        )
    }

    companion object {
        const val LOTTO_MAX_REWARD = 2000000000
        const val LOTTO_TICKET_PRICE = 1000
    }
}
