package lotto.step4

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.step4.domain.AutoLottoPurchasableMoneyCalculator
import lotto.step4.domain.Money

class AutoLottoPurchasableMoneyCalculatorTest : FunSpec({
    test("calculateMoney()가 자동 로또 구매 개수를 올바르게 계산한다.") {
        // given
        val givenMoney = Money(10000L)
        val givenManualPurchaseCount = 3L
        // when
        val result =
            AutoLottoPurchasableMoneyCalculator.calculateMoney(
                money = givenMoney,
                manualPurchaseCount = givenManualPurchaseCount,
            )
        // then
        result shouldBe Money(7000L)
    }
})
