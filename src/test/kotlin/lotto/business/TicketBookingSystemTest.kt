package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TicketBookingSystemTest {

    @ParameterizedTest
    @CsvSource(value = ["1000,1", "2000,2", "3000,3", "4000,4", "5000,5"])
    fun `1000원 단위로 로또를 구매할 수 있다`(money: Int, expectedCount: Int) {
        // given
        val ticketBookingSystem = TicketBookingSystem(LottoTicketGenerator())

        // when
        val lottoTickets = ticketBookingSystem.buyLotto(money)

        // then
        assertThat(lottoTickets.size).isEqualTo(expectedCount)
    }

    @ParameterizedTest
    @CsvSource(value = ["1000,1", "2000,2", "3000,3", "4000,4", "5000,5"])
    fun `구입금액으로 로또 티켓 개수를 계산한다`(money: Int, expectedCount: Int) {
        // given
        val ticketBookingSystem = TicketBookingSystem(LottoTicketGenerator())

        // when
        val count = ticketBookingSystem.getTicketCount(money)

        // then
        assertThat(count).isEqualTo(expectedCount)
    }
}
