package lotto

import lotto.exception.MinimumPurchaseMoneyException
import lotto.exception.NotNumericException
import lotto.seller.LottoSeller
import lotto.validation.PurchaseValidate
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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
        val money = "500"
        val purchaseValidate = PurchaseValidate()

        Assertions.assertThatThrownBy { purchaseValidate.validate(money) }
            .isInstanceOf(MinimumPurchaseMoneyException::class.java)
    }

    @Test
    fun `입력값이 숫자가 아니면 에러처리`() {
        val money = "string"
        val purchaseValidate = PurchaseValidate()

        Assertions.assertThatThrownBy { purchaseValidate.validate(money) }
            .isInstanceOf(NotNumericException::class.java)
    }

}
