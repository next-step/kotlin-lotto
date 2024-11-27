package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoPurchaseCalculatorTest : StringSpec({
    "should calculate the number of lotto tickets from the given amount" {
        DefaultLottoPurchaseCalculator().calculateTicketCount(14000) shouldBe 14
        DefaultLottoPurchaseCalculator().calculateTicketCount(1500) shouldBe 1
    }
})
