package lotto

import lotto.domain.Lotto
import lotto.domain.LottoPurchase
import lotto.domain.LottoPurchase.Companion.DEFAULT_PRICE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoPurchaseTest {
    @Test
    fun `로또를 구입할 수 있다`() {
        val manualLottosNumbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(4, 5, 6, 7, 8, 9)
        )
        val budget = 3000

        val lotto = LottoPurchase(budget, DEFAULT_PRICE, manualLottosNumbers).purchaseManualAndAuto().lottos[0]
        assertThat(lotto).isInstanceOf(Lotto::class.java)
    }

    @Test
    fun `로또 1장의 가격은 1000원이다`() {
        assertThat(DEFAULT_PRICE).isEqualTo(1000)
    }
}
