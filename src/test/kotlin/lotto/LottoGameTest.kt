package lotto

import lotto.domain.LottoGame
import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameTest {

    @Test
    fun `금액에 맞는 로또티켓이 잘 만들어지는지 확인`() {
        val lottoTickets = listOf<LottoTicket>(
            LottoTicket(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(4),
                    LottoNumber(6)
                )
            )
        )
        val lottoTicket = LottoGame.createLottoTicket(3000, lottoTickets)
        assertThat(lottoTicket.lottoTickets.size).isEqualTo(3)
    }
}
