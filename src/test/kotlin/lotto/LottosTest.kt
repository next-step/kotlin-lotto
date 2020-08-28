package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottosTest {

    @Test
    @DisplayName("ticket size check")
    fun ticketSizeCheck() {
        val sampleTicket = Lottos(14)
        assertThat(sampleTicket.purchasedLotto.size).isEqualTo(14)
    }
}
