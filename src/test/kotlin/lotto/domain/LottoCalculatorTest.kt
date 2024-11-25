package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoCalculatorTest : StringSpec({
    "should calculate the number of lotto tickets from the given amount"  {
        LottoCalculator.calculateTicketCount(10000) shouldBe 10
        LottoCalculator.calculateTicketCount(1500) shouldBe 1
    }
})
