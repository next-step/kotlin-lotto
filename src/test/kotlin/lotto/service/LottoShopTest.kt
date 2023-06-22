package lotto.service

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoShopTest : FunSpec({
    context("구입금액 만큼 로또를 구매한다.") {
        withData(
            1000 to 1,
            2000 to 2,
            14000 to 14,
        ) { (purchaseMoney, expectedCount) ->
            val lottos = LottoShop.purchase(purchaseMoney)
            lottos.size shouldBe expectedCount
        }
    }
})
