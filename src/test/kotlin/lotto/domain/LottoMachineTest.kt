package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("로또 티켓 발급 테스트")
class LottoMachineTest {

    private val ticketPrice = LottoConstants.TICKET_PRICE
    private val lottoMachine = LottoMachine(ticketPrice)

    @Test
    @DisplayName("1000원으로 구입 시 1장의 티켓을 발급한다")
    fun `1000원으로 구입 시 1장의 티켓을 발급한다`() {
        val tickets = lottoMachine.generateTickets(ticketPrice)
        assertEquals(1, tickets.size)
    }

    @Test
    @DisplayName("5000원으로 구입 시 5장의 티켓을 발급한다.")
    fun `5000원으로 구입 시 5장의 티켓을 발급한다`() {
        val tickets = lottoMachine.generateTickets(5 * ticketPrice)
        assertEquals(5, tickets.size)
    }

    @Test
    @DisplayName("로또 티켓의 번호는 1부터 45 사이여야 한다")
    fun `로또 티켓의 번호는 1부터 45 사이여야 한다`() {
        val ticket = LottoTicket.generate()
        assertTrue(ticket.getNumbers().all { it in 1..45 })
    }

    @DisplayName("번호의 갯수가 부족한 로또 티켓 생성 시 예외 발생")
    fun `번호의 갯수가 부족한 로또 티켓 생성 시 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            LottoTicket(listOf(1, 2, 3, 4, 5))
        }
    }

    @DisplayName("번호가 중복된 로또 티켓 생성 시 예외 발생")
    fun `번호가 중복된 로또 티켓 생성 시 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            LottoTicket(listOf(1, 1, 2, 3, 4, 5))
        }
    }

    @DisplayName("번호 범위를 벗어난 로또 티켓 생성 시 예외 발생")
    fun `번호 범위를 벗어난 로또 티켓 생성 시 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            LottoTicket(listOf(0, 1, 2, 3, 4, 46))
        }
    }
}
