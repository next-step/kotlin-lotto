package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoMachineTest {

    private fun List<Int>.toLottoNumber() = this.map { LottoNumber(it) }
    private val randomNumberFunc = { (1..6).toList().toLottoNumber() }

    @Test
    fun `로또 기계에 보너스 값을 전달한다`() {
        val lottoTickets = LottoMachine().purchase(
            money = Money(1000),
            manualTickets = LottoTickets(),
            randomNumberFunc = randomNumberFunc
        )

        assertThat(lottoTickets.autoTickets.ticketSize).isEqualTo(1)
    }

    @Test
    fun `로또 기계는 티켓 구매시 수동 티켓을 제외한 차액만큼 자동 티켓을 생성한다`() {
        val purchase = LottoMachine().purchase(
            money = Money(3000),
            manualTickets = LottoTickets(
                listOf(LottoTicket(listOf(1, 2, 3, 4, 5, 6).toLottoNumber()))
            ),
            randomNumberFunc = randomNumberFunc
        )

        assertThat(purchase.manualTickets.ticketSize).isEqualTo(1)
        assertThat(purchase.autoTickets.ticketSize).isEqualTo(2)
    }

    @Test
    fun `티켓 구매 전액이 수동 번호로 입력된 경우 자동 티켓 0을 확인한다`() {
        val purchase = LottoMachine().purchase(
            money = Money(3000),
            manualTickets = LottoTickets(
                listOf(
                    LottoTicket(listOf(1, 2, 3, 4, 5, 6).toLottoNumber()),
                    LottoTicket(listOf(10, 12, 13, 14, 15, 16).toLottoNumber()),
                    LottoTicket(listOf(21, 22, 23, 24, 25, 26).toLottoNumber()),
                )
            ),
            randomNumberFunc = randomNumberFunc
        )

        assertThat(purchase.manualTickets.ticketSize).isEqualTo(3)
        assertThat(purchase.autoTickets.ticketSize).isEqualTo(0)
    }
}
