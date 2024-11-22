package lotto

import lotto.domain.LottoSeller
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoSellerTest {
    @Test
    fun `로또 구매금액을 입력받는다`() {
        val lottoSeller = LottoSeller(5000)
        assertThat(lottoSeller.purchasePrice).isEqualTo(5000)
    }

    @Test
    fun `로또 한장의 가격은 1000원이다`() {
        assertThat(LottoSeller.Companion.LOTTO_PRICE).isEqualTo(1000)
    }

    @Test
    fun `로또 구매 갯수는 구매금액을 한장 가격으로 나눈 값이다`() {
        val lottoSeller = LottoSeller(5000)
        assertThat(lottoSeller.getLottoPurchaseCount()).isEqualTo(5)
    }
}
