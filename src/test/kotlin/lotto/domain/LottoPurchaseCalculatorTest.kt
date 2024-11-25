package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoPurchaseCalculatorTest : StringSpec({
    "should calculate the number of lotto tickets from the given amount" {
        LottoPurchaseCalculator.calculateTicketCount(10000) shouldBe 10
        LottoPurchaseCalculator.calculateTicketCount(1500) shouldBe 1
    }
})
