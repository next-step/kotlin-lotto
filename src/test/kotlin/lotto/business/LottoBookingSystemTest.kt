package lotto.business

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoBookingSystemTest {

    @DisplayName("로또 티켓을 개수만큼 생성한다")
    @Test
    fun generateMultipleTickets() {
        // given
        val lottoBookingSystem = LottoBookingSystem()

        // when
        val lottoTickets = lottoBookingSystem.generateMultipleTickets(3)

        // then
        Assertions.assertAll(
            { Assertions.assertEquals(3, lottoTickets.size) },
        )
    }
}
