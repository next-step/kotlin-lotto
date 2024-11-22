package lotto

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 구매금액을 입력받는다`() {
        val lotto = Lotto(5000)
        assertThat(lotto.purchasePrice).isEqualTo(5000)
    }

    @Test
    fun `로또 한장의 가격은 1000원이다`() {
        assertThat(Lotto.Companion.LOTTO_PRICE).isEqualTo(1000)
    }

    @Test
    fun `로또 구매 갯수는 구매금액을 한장 가격으로 나눈 값이다`() {
        val lotto = Lotto(5000)
        assertThat(lotto.getLottoPurchaseCount()).isEqualTo(5)
    }
}
