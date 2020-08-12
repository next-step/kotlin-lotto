package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoMoneyTest {

    @Test
    fun `살 수 있는 티켓 개수 반환 확인`() {
        // given
        val lottoMoney = LottoMoney(3_500)

        // then
        assertThat(lottoMoney.ticketCountCanBuy).isEqualTo(3)
    }

    @Test
    fun `일정 개수 티켓을 소비하고 남은 돈을 확인`() {
        // given
        val lottoMoney = LottoMoney(5_000)

        // then
        assertThat(lottoMoney.spendTicketCountOf(3)).isEqualTo(LottoMoney(2_000))
    }
}
