package lotto.model

import lotto.LottoAllTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class WinningCalculatorTest {
    @Test
    fun `당첨 통계를 계산한다`() {
        var test1Ticket = AutomaticLottoTicketGenerator(1).lottoNumbers
        val test1WinningNumber = test1Ticket[0].values.toString().replace("[", "").replace("]", "")

        var test2Ticket = AutomaticLottoTicketGenerator(1).lottoNumbers
        var test2WinningNumber = test2Ticket[0].values.toString().replace("[", "").replace("]", "")

        assertAll(
            {
                val testCalculator = WinningCalculator(test1Ticket, LottoTicket(test1WinningNumber), 1)
                assertEquals(
                    (LottoAllTest.LOTTO_MAX_REWARD / (test1Ticket.size * LottoAllTest.LOTTO_TICKET_PRICE)).toDouble(),
                    testCalculator.calculateRate(test1Ticket.size)
                )
            },
            {
                val testCalculator = WinningCalculator(test2Ticket, LottoTicket(test2WinningNumber), 1)
                assertEquals(
                    (LottoAllTest.LOTTO_MAX_REWARD / (test2Ticket.size * LottoAllTest.LOTTO_TICKET_PRICE)).toDouble(),
                    testCalculator.calculateRate(test2Ticket.size)
                )
            }
        )
    }

    companion object {
        const val LOTTO_MAX_REWARD = 2000000000
        const val LOTTO_TICKET_PRICE = 1000
    }
}
