package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoShopTest : BehaviorSpec({
    Given("1. 로또샵") {
        val lottoShop = LottoShop()

        When("1000 단위 X [999]") {
            val exception =
                shouldThrow<IllegalArgumentException> {
                    lottoShop.buyLotto(999)
                }
            Then("예외가 나온다") {
                exception.message shouldBe "1000원 단위로 입력안됨"
            }
        }
    }

    Given("2. 로또샵") {
        val lottoShop = LottoShop()

        When("1000 단위 X [998]") {
            val exception =
                shouldThrow<IllegalArgumentException> {
                    lottoShop.buyLotto(998)
                }
            Then("예외가 나온다") {
                exception.message shouldBe "1000원 단위로 입력안됨"
            }
        }
    }

    Given("3. 로또샵") {
        val lottoShop = LottoShop()

        When("1000 단위 O [1000]") {
            val lottoCount = lottoShop.buyLotto(1000)
            Then("로또 1장이 나온다") {
                lottoCount shouldBe 1
            }
        }
    }

    Given("4. 로또샵") {
        val lottoShop = LottoShop()

        When("1000 단위 O [2000]") {
            val lottoCount = lottoShop.buyLotto(2000)
            Then("로또 2장이 나온다") {
                lottoCount shouldBe 2
            }
        }
    }
})
