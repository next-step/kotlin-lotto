package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : BehaviorSpec({

    Given("고객이 로또를 구매한 금액과 로또 결과가 존재한다면") {
        val customer = Customer.of("14000")
        val lottoResult = LottoResult(
            mapOf(
                LottoRank.FOURTH_PLACE to 1
            )
        )
        Then("수익률을 계산할 수 있다.") {
            lottoResult.getRateOfReturn(customer) shouldBe 0.35
        }
    }
})
