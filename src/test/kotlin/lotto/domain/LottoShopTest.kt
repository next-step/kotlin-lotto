package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoShopTest : BehaviorSpec({

    Given("고객이 3000원의 돈을 가지고 있을 때") {
        val customer = Customer("3000")
        When("로또를 구매한다면") {
            val lotto = LottoShop().buyLotto(customer)
            Then("3개의 라인을 구매한다.") {
                lotto.lines.size shouldBe 3
            }
        }
    }
})
