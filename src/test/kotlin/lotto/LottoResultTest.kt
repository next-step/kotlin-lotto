package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoResult
import lotto.domain.Rank

internal class LottoResultTest : BehaviorSpec({

    Given("LottoResult") {
        When("각 등수마다 1개씩 당첨됐을 때") {
            val lottoResult = LottoResult(
                mapOf(
                    Rank.FOURTH to 1,
                    Rank.THIRD to 1,
                    Rank.SECOND to 1,
                    Rank.SECOND_BONUS to 1,
                    Rank.FIRST to 1
                )
            )
            Then("getTotalPrize() 메서드는 result에 맞는 값을 반환한다.") {
                val actual = lottoResult.getTotalPrize()
                val expect = Rank.values().sumOf { it.prize }
                actual shouldBe expect
            }
            Then("getRateOfReturn() 메서드는 총 상금 / 구매 가격을 반환한다.") {
                val actual = lottoResult.getRateOfReturn()
                val expect = Rank.values().sumOf { it.prize } / 5000.0
                actual shouldBe expect
            }
        }

        When("각 등수마다 2개씩 당첨됐을 때") {
            val lottoResult = LottoResult(
                mapOf(
                    Rank.FOURTH to 2,
                    Rank.THIRD to 2,
                    Rank.SECOND to 2,
                    Rank.SECOND_BONUS to 2,
                    Rank.FIRST to 2
                )
            )
            Then("getTotalPrize() 메서드는 result에 맞는 값을 반환한다.") {
                val actual = lottoResult.getTotalPrize()
                val expect = Rank.values().sumOf { it.prize } * 2
                actual shouldBe expect
            }
            Then("getRateOfReturn() 메서드는 총 상금 / 구매 가격을 반환한다.") {
                val actual = lottoResult.getRateOfReturn()
                val expect = Rank.values().sumOf { it.prize } * 2L / 10000.0
                actual shouldBe expect
            }
        }
    }
})
