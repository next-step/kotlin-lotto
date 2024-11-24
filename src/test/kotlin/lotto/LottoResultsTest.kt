package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoResultsTest : BehaviorSpec({

    Given("로또 결과에") {
        val lottoResults = LottoResults()

        When("2등 당첨된 사람을 추가하면") {
            lottoResults.counting(LottoResult(LottoRank.SECOND))

            Then("sum()은 1,500,000원을 반환한다") {
                lottoResults.results.find { it.lottoRank == LottoRank.SECOND }?.sum() shouldBe 1_500_000
            }
        }
    }

    // 수익률 계싼을 추가한다.
    Given("로또 결과에 ") {
        val lottoResults = LottoResults()

        When("4등 당첨된 사람을 추가하면") {
            lottoResults.counting(LottoResult(LottoRank.FOURTH))

            Then("computeProfitRate(Price(14_000))은 0.35714285714285715을 반환한다") {
                lottoResults.computeProfitRate(Price(14_000)) shouldBe 0.35714285714285715
            }
        }
    }
})
