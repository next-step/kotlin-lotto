package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TicketBookingSystemTest {

    @ParameterizedTest
    @CsvSource(value = ["1000,1", "2000,2", "3000,3", "4000,4", "5000,5"])
    fun `받은 금액만큼 로또를 구매할 수 있다`(amount: Int, expectedCount: Int) {
        // given
        val ticketBookingSystem = TicketBookingSystem(LottoTicketGenerator())

        // when
        val lottoTickets = ticketBookingSystem.buyLotto(ReceivedAmount(amount))

        // then
        assertThat(lottoTickets.size).isEqualTo(expectedCount)
    }
}
