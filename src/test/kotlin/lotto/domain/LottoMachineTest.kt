package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {

    private val ticketPrice = LottoConstants.TICKET_PRICE

    @Test
    @DisplayName("지정된 금액으로 적절한 수의 로또 티켓을 발급해야 한다")
    fun `should issue the correct number of tickets for a given amount`() {
        val lottoMachine = LottoMachine(ticketPrice)
        val tickets = lottoMachine.generateTickets(5 * ticketPrice)
        assertEquals(5, tickets.size)
    }

    @Test
    @DisplayName("로또 티켓의 번호가 1부터 45 사이에 있어야 한다")
    fun `LottoTicket's numbers should be between 1 and 45`() {
        val lottoMachine = LottoMachine(ticketPrice)
        val ticket = lottoMachine.generateTicket()
        assertTrue(ticket.getNumbers().all { it in 1..45 })
    }

    @Test
    @DisplayName("로또 티켓이 유효하지 않은 번호로 생성될 때 예외를 발생시키는지 테스트")
    fun testLottoTicketValidation() {
        assertThrows<IllegalArgumentException> {
            LottoTicket(listOf(1, 2, 3, 4, 5))
        }
    }
}
