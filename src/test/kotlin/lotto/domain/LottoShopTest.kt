package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class LottoShopTest : BehaviorSpec({

    Given("수동 구매는 존재하지 않고 3개의 자동을") {
        val purchase = LottoPurchase.valueOf("3000")
        When("로또를 구매한다면") {
            val lotto = LottoShop.buyLotto(purchase)
            Then("3개의 자동 라인이 기입된 로또를 반환한다.") {
                lotto.autoLines.size shouldBe 3
            }
        }
    }

    Given("수동 구매 2개, 자동 구매 2개의 구매정보가 존재하고") {
        val purchase = LottoPurchase.valueOf("4000", "2")
        val manualLottoLines = listOf(
            LottoLine.valueOf("1, 2, 3, 4, 5, 6"),
            LottoLine.valueOf("7, 8, 9, 10, 11, 12")
        )
        When("로또를 구매한다면") {
            val lotto = LottoShop.buyLotto(purchase, manualLottoLines)
            Then("4개의 라인이 기입된 로또를 반환한다.") {
                lotto.autoLines.size shouldBe 2
                lotto.manualLines.size shouldBe 2
                lotto.manualLines shouldBe manualLottoLines
            }
        }
    }
})
