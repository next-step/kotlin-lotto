package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DashBoardTest {

    private val dashBoard = DashBoard()
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7
    private val amount = 3000
    private val ticketPrice = 1000

    @Test
    fun `수익률 검증`() {
        val tickets = this.tickets()
        val result = tickets.result(winningNumbers, bonusNumber)

        val expected = (Rank.FIRST.prize * (amount / ticketPrice)).div(amount.toDouble())
        val earnings = dashBoard.earnings(result, amount)
        assertEquals(expected, earnings)
    }

    private fun tickets(): Tickets {
        val ticketGenerator = TicketGenerator(RandomNumberStrategy(winningNumbers))

        return ticketGenerator.tickets(amount)
    }

}
