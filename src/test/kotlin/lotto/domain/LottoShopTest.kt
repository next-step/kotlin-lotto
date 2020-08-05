package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoShopTest {

    @Test
    fun `원하는 개수만큼의 티켓을 발급하는지 확인`() {
        // given
        val lottoShop = LottoShop(LottoTicketGenerator())
        val lottoTickets = lottoShop.getAutoTickets(1_000 * 10)

        // then
        assertThat(lottoTickets.size()).isEqualTo(10)
    }
}
