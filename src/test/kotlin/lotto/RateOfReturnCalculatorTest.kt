package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.common.value.Money
import lotto.application.RateOfReturnCalculator

class RateOfReturnCalculatorTest : FreeSpec({

    "수익률을 구할 수 있다" {
        val paymentPrice = Money.from(14_000)
        val prizeAmount = Money.from(5_000)
        val rateOfReturn = RateOfReturnCalculator.calculate(paymentPrice, prizeAmount)
        rateOfReturn.toString() shouldBe 0.35.toString()
    }
})
