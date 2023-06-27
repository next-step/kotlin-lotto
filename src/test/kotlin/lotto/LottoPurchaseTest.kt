package lotto

import lotto.domain.LottoPurchase
import lotto.domain.LottoPurchase.Companion.DEFAULT_PRICE
import lotto.domain.Lottos
import lotto.vo.OrderRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class LottoPurchaseTest {
    @Test
    fun `로또를 구입할 수 있다`() {
        val manualLottosNumbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(4, 5, 6, 7, 8, 9)
        )
        val budget = 3000

        val request = OrderRequest(budget, DEFAULT_PRICE, manualLottosNumbers)
        val lottos = LottoPurchase(request).purchaseManualAndAuto()
        assertThat(lottos).isInstanceOf(Lottos::class.java)
    }

    @Test
    fun `로또 1장의 가격은 1000원이다`() {
        assertThat(DEFAULT_PRICE).isEqualTo(1000)
    }

    @Test
    fun `구입금액 예산을 초과해서 구매할 경우 IllegalArgumentException`() {
        val manualLottosNumbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(4, 5, 6, 7, 8, 9)
        )
        val budget = 1000
        val request = OrderRequest(budget, DEFAULT_PRICE, manualLottosNumbers)

        assertThrows<IllegalArgumentException> {
            LottoPurchase(request).purchaseManualAndAuto()
        }
    }
}
