package lotto.domain

import lotto.dto.LottoTicketNumbers
import lotto.dto.ManualLottoTickets
import lotto.dto.PurchaseAmount
import lotto.`interface`.impl.ManualTicketGenerationStrategy
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
        assertEquals(1, tickets.tickets.size)
    }

    @Test
    @DisplayName("5000원으로 구입 시 5장의 티켓을 발급한다.")
    fun `5000원으로 구입 시 5장의 티켓을 발급한다`() {
        val tickets = lottoMachine.generateTickets(5 * ticketPrice)
        assertEquals(5, tickets.tickets.size)
    }

    @Test
    @DisplayName("로또 티켓의 번호는 1부터 45 사이여야 한다")
    fun `로또 티켓의 번호는 1부터 45 사이여야 한다`() {
        val ticket = LottoTicket.generate()
        assertTrue(ticket.readOnlyNumbers.all { it.number in 1..45 })
    }

    @Test
    @DisplayName("번호의 갯수가 부족한 로또 티켓 생성 시 예외 발생")
    fun `번호의 갯수가 부족한 로또 티켓 생성 시 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            LottoTicket.from(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    @DisplayName("번호가 중복된 로또 티켓 생성 시 예외 발생")
    fun `번호가 중복된 로또 티켓 생성 시 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            LottoTicket.from(listOf(1, 1, 2, 3, 4, 5))
        }
    }

    @Test
    @DisplayName("번호 범위를 벗어난 로또 티켓 생성 시 예외 발생")
    fun `번호 범위를 벗어난 로또 티켓 생성 시 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            LottoTicket.from(listOf(0, 1, 2, 3, 4, 46))
        }
    }

    @Test
    @DisplayName("수동 티켓 번호가 올바른 형식, 범위, 개수를 갖는지 검증")
    fun `수동 티켓 번호가 올바른 형식인지 검증한다`() {
        val manualNumbers = listOf(1, 2, 3, 4, 5, 6)
        val ticket = ManualTicketGenerationStrategy(manualNumbers).generate()
        assertTrue(ticket.readOnlyNumbers.map { it.number } == manualNumbers)
    }

    @Test
    @DisplayName("지정된 금액에 맞춰 적절한 수의 수동 및 자동 티켓이 생성되는지 검증")
    fun `주어진 금액에 따라 올바른 수의 수동 및 자동 티켓이 생성된다`() {
        val manualTicketNumbersList = listOf(
            LottoTicketNumbers(listOf(1, 2, 3, 4, 5, 6)),
            LottoTicketNumbers(listOf(7, 8, 9, 10, 11, 12))
        )
        val manualLottoTickets = ManualLottoTickets(manualTicketNumbersList.map { LottoTicket.from(it.numbers) })
        val purchaseAmount = PurchaseAmount(7000)
        val tickets = lottoMachine.generateTickets(purchaseAmount.amount, manualLottoTickets)

        assertEquals(7, tickets.tickets.size)
        assertTrue(tickets.tickets.take(2).all { it.readOnlyNumbers.map { num -> num.number } in manualTicketNumbersList.map { it.numbers } })
        assertTrue(tickets.tickets.drop(2).all { it.readOnlyNumbers.all { num -> num.number in 1..45 } })
    }
}
