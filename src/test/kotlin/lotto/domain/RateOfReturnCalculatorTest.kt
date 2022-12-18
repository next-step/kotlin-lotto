package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.application.RateOfReturnCalculator
import lotto.common.value.Money.Companion.toMoney

class RateOfReturnCalculatorTest : FreeSpec({

    "수익률을 구할 수 있다" {
        val paymentPrice = 14_000L.toMoney()
        val prizeAmount = 5_000L.toMoney()
        val rateOfReturn = RateOfReturnCalculator.calculate(paymentPrice, prizeAmount)
        rateOfReturn.toString() shouldBe 0.35.toString()
    }
})
