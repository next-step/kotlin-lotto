package lotto

import lotto.domain.LottoGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameTest {

    @Test
    fun `금액에 맞는 로또티켓이 잘 만들어지는지 확인`() {
        val lottoTicket = LottoGame.createLottoTicket(3000)
        assertThat(lottoTicket.lottoTickets.size).isEqualTo(3)
    }
}
