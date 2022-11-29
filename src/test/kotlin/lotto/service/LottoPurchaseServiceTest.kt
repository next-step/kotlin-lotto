package lotto.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize

class LottoPurchaseServiceTest : StringSpec({
    "5000원을 지불하면 로또 5장을 받는다" {
        LottoPurchaseService.purchase(5000) shouldHaveSize 5
    }
})
