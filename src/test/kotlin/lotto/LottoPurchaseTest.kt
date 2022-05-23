package lotto

import lotto.exception.MinimumPurchaseMoneyException
import lotto.seller.LottoSeller
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoPurchaseTest {

    @Test
    fun `입력된 구입 금액만큼 로또를 n개 구입`() {
        val money = 13500
        val lottoSeller = LottoSeller()
        val lottoPurchaseAmount = lottoSeller.calculateLottoPurchaseAmount(money)
        val purchaseLottoTickets = lottoSeller.sell(lottoPurchaseAmount)

        assertThat(purchaseLottoTickets.size).isEqualTo(lottoPurchaseAmount)
    }

    @Test
    fun `입력된 구입 금액이 1개를 구매할 수 있는 최소 금액이 넘지 않으면 에러처리`() {
        val money = 500
        val lottoSeller = LottoSeller()

        Assertions.assertThatThrownBy { lottoSeller.calculateLottoPurchaseAmount(money) }
            .isInstanceOf(MinimumPurchaseMoneyException::class.java)
    }

}
