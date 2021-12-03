package lotto.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 *
 * @author Leo
 */
class TicketsTest {

    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7
    private val amount = 3000

    @Test
    fun `결과 검증`() {
        val tickets = this.tickets()
        val firsts = tickets.result(winningNumbers, bonusNumber)[Rank.FIRST]

        Assertions.assertEquals(3, firsts!!.size)
    }

    private fun tickets(): Tickets {
        val ticketGenerator = TicketGenerator(RandomNumberStrategy(winningNumbers))

        return ticketGenerator.tickets(amount)
    }

}
