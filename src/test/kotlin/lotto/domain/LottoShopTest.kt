package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class LottoShopTest : BehaviorSpec({

    val lottoShop = LottoShop()
    Given("고객이 3000원의 돈을 가지고 있을 때") {
        val customer = Customer.valueOf("3000")
        When("로또를 구매한다면") {
            val lotto = lottoShop.buyLotto(customer.money)
            Then("3개의 라인을 구매한다.") {
                lotto.lines.size shouldBe 3
            }
        }
    }

    Given("고객이 로또를 구매할 최소 금액의 돈을 가지고 있지 않을 때") {
        val customer = Customer(300)
        When("로또를 구매한다면") {
            Then("예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    lottoShop.buyLotto(customer.money)
                }
            }
        }
    }
})
