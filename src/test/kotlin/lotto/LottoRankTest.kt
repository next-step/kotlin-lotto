package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.LottoRank.SECOND

class LottoRankTest : BehaviorSpec({

    Given("로또 순위에") {
        When("FIRST일 때") {
            val lottoRank = LottoRank.FIRST

            Then("sumPrice(1)은 2,000,000,000원을 반환한다") {
                lottoRank.sumPrice(Count(1)) shouldBe 2_000_000_000
            }
        }

        When("SECOND일 때") {
            val second = SECOND

            Then("sumPrice(1)은 1,500,000원을 반환한다") {
                second.sumPrice(Count(1)) shouldBe 30_000_000
            }
        }
    }

    Given("맞춘 개수에") {
        val matchCount = 3

        When("3개를 맞췄을 때") {
            Then("valueOf(3)은 FOURTH를 반환한다") {
                LottoRank.valueOf(matchCount) shouldBe LottoRank.FIFTH
            }
        }

        When("6개를 맞췄을 때") {
            Then("valueOf(6)은 FIRST를 반환한다") {
                LottoRank.valueOf(6) shouldBe LottoRank.FIRST
            }
        }
    }
})
