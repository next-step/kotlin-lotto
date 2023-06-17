package lotto

import lotto.domain.Lotto
import lotto.domain.LottoPurchase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoPurchaseTest {
    @Test
    fun `로또를 구입할 수 있다`() {
        assertThat(LottoPurchase().purchaseAuto(1000, LottoPurchase.DEFAULT_PRICE)[0]).isInstanceOf(Lotto::class.java)
    }

    @ParameterizedTest
    @ValueSource(ints = [3000, 4000])
    fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 로또 개수를 알 수 있다`(budget: Int) {
        assertThat(LottoPurchase().affordableLottoCount(budget, LottoPurchase.DEFAULT_PRICE)).isEqualTo(budget / LottoPurchase.DEFAULT_PRICE)
    }

    @Test
    fun `로또 1장의 가격은 1000원이다`() {
        assertThat(LottoPurchase.DEFAULT_PRICE).isEqualTo(1000)
    }
}
