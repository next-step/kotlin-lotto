package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TicketsTest {

    @ParameterizedTest
    @CsvSource("14,14000", "10,10000", "14,14999")
    fun `구입금액에 해당하는 로또 티켓들을 살 수 있다`(count: Int, value: Int) {
        val money = Money.of(value)
        val tickets = Tickets.from(money)
        assertThat(tickets.count()).isEqualTo(count)
    }
}
