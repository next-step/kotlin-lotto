package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.EarningsRateCalculator
import lotto.domain.Rank

class EarningRateCalculatorTest : BehaviorSpec({

    Given("로또 당첨 결과와 구매 금액으로") {
        When("수익률 계산기를 동작시키면") {
            val purchase = 14000
            val result = EarningsRateCalculator.run(result, purchase)
            Then("수익률이 계산된다.") {
                val expected = 0.35714287f
                result shouldBe expected
            }
        }
    }

    Given("수익률이") {
        When("1보다 작으면") {
            val rate = .5f
            val result = EarningsRateCalculator.isLoss(rate)
            Then("참을 반환한다.") {
                result shouldBe true
            }
        }
        When("1과 같거나 그보다 크면") {
            val rate = 1.0f
            val result = EarningsRateCalculator.isLoss(rate)
            Then("거짓을 반환한다.") {
                result shouldBe false
            }
        }
    }
}) {
    companion object {
        val result = mapOf(
            Rank.FIFTH to 1,
            Rank.FOURTH to 0,
            Rank.THIRD to 0,
            Rank.FIRST to 0
        )
    }
}
