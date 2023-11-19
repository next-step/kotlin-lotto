package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTicketTest {

    @Test
    @DisplayName("올바른 번호 목록으로 로또 티켓이 생성된다")
    fun `올바른 번호 목록으로 로또 티켓이 생성된다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val ticket = LottoTicket(numbers)
        assertEquals(numbers, ticket.readOnlyNumbers)
    }

    @Test
    @DisplayName("무작위로 생성된 티켓이 올바른 형식을 갖는다")
    fun `무작위로 생성된 티켓이 올바른 형식을 갖는다`() {
        val ticket = LottoTicket.generate()
        assertEquals(6, ticket.readOnlyNumbers.size)
        assertTrue(ticket.readOnlyNumbers.all { it in 1..45 })
    }
}
