package lotto.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : BehaviorSpec({
    Given("로또 결과가 1개 구매시  1등 1개 ") {
        val lottoResult = LottoResult(
            mapOf(Prize.FIRST to 1)
        )
        When("수익률을 구했을 때") {
            Then("수익률은 2000000.0") {
                lottoResult.profit shouldBe 2000000.0
            }
        }
    }
})
