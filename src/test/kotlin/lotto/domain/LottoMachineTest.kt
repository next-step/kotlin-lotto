package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    @DisplayName("로또 티켓을 올바르게 생성하는지 테스트")
    fun testGenerateTicket() {
        val lottoMachine = LottoMachine(1000)
        val ticket = lottoMachine.generateTicket()
        val numbers = ticket.getNumbers()
        assertEquals(6, numbers.size)
        assertTrue(numbers.all { it in 1..45 })
    }

    @Test
    @DisplayName("주어진금액에 맞게 올바른 수의 티켓을 생성하는지 테스트")
    fun generateTickets() {
        val lottoMachine = LottoMachine(LottoConstants.TICKET_PRICE)
        val tickets = lottoMachine.generateTickets(5000)
        assertEquals(5, tickets.size, "5000원으로 5장의 로또 티켓을 구매해야 함")
    }

    @Test
    @DisplayName("중복 없이 정렬된 번호를 생성하는지 테스트")
    fun generateTicketUnique() {
        val lottoMachine = LottoMachine(LottoConstants.TICKET_PRICE)
        val ticket = lottoMachine.generateTicket()
        val numbers = ticket.getNumbers()
        assertTrue(numbers.distinct().size == 6, "로또 번호에 중복이 있으면 안됨")
        assertTrue(numbers.sorted() == numbers, "로또 번호가 정렬되어 있어야 함")
    }
}
