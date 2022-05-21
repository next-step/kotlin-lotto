package camp.nextstep.lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoTicketTest {

    @DisplayName("로또 티켓은 6개의 숫자를 가진다.")
    @Test
    fun sixNumbersTest() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val ticket = LottoTicket(numbers)

        assertEquals(6, ticket.numbers.size)
        assertTrue(ticket.numbers.containsAll(numbers))
    }

    @DisplayName("로또 티켓은 6개보다 적은 숫자를 가질 수 없다.")
    @Test
    fun lessThanSixNumbersTest() {
        val numbers = listOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> { LottoTicket(numbers) }
    }

    @DisplayName("로또 티켓은 6개보다 많은 숫자를 가질 수 없다.")
    @Test
    fun moreThanSixNumbersTest() {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
        assertThrows<IllegalArgumentException> { LottoTicket(numbers) }
    }

    @DisplayName("로또 티켓은 같은 숫자를 여러 개 가질 수 없다.")
    @Test
    fun ticketDuplicatedNumberTest() {
        val numbers = listOf(1, 2, 1, 4, 5, 6)
        assertThrows<IllegalArgumentException> { LottoTicket(numbers) }
    }
}
