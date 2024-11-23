package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoUserTest {
    @Test
    fun `사용자는 구매금액을 가지고 있는다`() {
        val lottoPurchaseAmount = LottoPurchaseAmount(1000)

        val lottoUser = LottoUser(lottoPurchaseAmount)

        lottoUser.lottoPurchaseAmount shouldBe lottoPurchaseAmount
    }

    @Test
    fun `사용자는 지불한 금액만큼의 로또를 가지고 있는다`() {
        val lottoPurchaseAmount = LottoPurchaseAmount(1000)

        val lottoUser = LottoUser(lottoPurchaseAmount)

        lottoUser.lotteries.size shouldBe lottoPurchaseAmount.calculateLottoCount()
    }

    @Test
    fun `사용자는 당첨금액을 알고 있다`() {
    }
}
