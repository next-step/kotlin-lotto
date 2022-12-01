package lotto.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import lotto.domain.Payment

class LottoPurchaseServiceTest : StringSpec({
    "5000원을 지불하면 로또 5장을 받는다" {
        LottoPurchaseService.purchase(Payment(5000)) shouldHaveSize 5
    }
})
