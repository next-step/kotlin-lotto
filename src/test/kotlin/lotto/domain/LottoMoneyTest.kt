package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMoneyTest {

    @Test
    fun `로또 금액을 입력하면 로또 티켓의 수를 계산한다`() {
        // given
        val lottoMoney = LottoMoney(14000)

        // when
        val quantity = lottoMoney.calculateQuantity()

        // then
        assertThat(quantity).isEqualTo(14)
    }
}
