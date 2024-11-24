package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : BehaviorSpec({

    Given("2등 당첨된 1명인 로또 결과에") {
        val lottoResult = LottoResult(lottoRank = LottoRank.SECOND)

        When("2등 당첨금을 계산하면") {
            lottoResult.count()

            Then("sum()은 1,500,000원을 반환한다") {
                lottoResult.sum() shouldBe 1_500_000
            }
        }

        When("추가 당첨자가 나오면") {
            lottoResult.count()

            Then("sum()은 3,000,000원을 반환한다") {
                lottoResult.sum() shouldBe 3_000_000
            }
        }
    }
})
