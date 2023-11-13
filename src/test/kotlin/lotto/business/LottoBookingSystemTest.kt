package lotto.business

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LottoBookingSystemTest {

    @Test
    fun `로또 티켓을 개수만큼 생성한다`() {
        // given
        val lottoBookingSystem = LottoBookingSystem()

        // when
        val lottoTickets = lottoBookingSystem.generateMultipleTickets(3)

        // then
        Assertions.assertAll(
            { Assertions.assertEquals(3, lottoTickets.size) },
        )
    }

    @Test
    fun `로또 수동 생성 개수가 플레이의 구매수량 보다 많으면 예외가 발생한다`() {
        // given
        val lottoBookingSystem = LottoBookingSystem()
        val player = Player(purchasableCount = 3)

        // when,then
        assertThatThrownBy {
            lottoBookingSystem.generateManualTickets(4, player)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("구매 가능한 로또 개수보다 많습니다.")
    }
}
