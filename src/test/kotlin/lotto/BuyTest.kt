package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BuyTest {
    @Test
    @DisplayName("ticket size check")
    fun ticketSizeCheck() {
        val sampleTicket = Ticket()
        sampleTicket.tickets(14)
        assertThat(sampleTicket.purchasedLottootto.size).isEqualTo(14)
    }
}
