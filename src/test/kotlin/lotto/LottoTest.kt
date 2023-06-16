package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto

class LottoTest : BehaviorSpec({

    Given("구매 금액을 입력받으면") {
        val input = 2000
        When("로또를 생성할 때") {
            val lotto = Lotto.of(input)
            Then("1장에 1000원이다.") {
                lotto.lottoList.size shouldBe 2
            }
        }
    }
})
