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

    Given("로또를 구매할 최소 금액의 돈이 존재하지 않을 때") {
        val purchase = LottoPurchase.valueOf("300")
        When("로또를 구매한다면") {
            Then("예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    lottoShop.buyLotto(purchase)
                }
            }
        }
    }

    Given("고객이 로또를 구매할 금액보다 수동으로 구매할 수가 더 크다면") {

    }
})
