package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class LottoShopTest : BehaviorSpec({

    val lottoShop = LottoShop()
    Given("3000원의 돈이 있을 때") {
        val purchase = LottoPurchase.valueOf("3000")
        When("로또를 구매한다면") {
            val lotto = lottoShop.buyLotto(purchase)
            Then("3개의 라인을 구매한다.") {
                lotto.lines.size shouldBe 3
            }
        }
    }
})
