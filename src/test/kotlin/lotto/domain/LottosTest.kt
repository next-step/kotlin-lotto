package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottosTest : BehaviorSpec({

    Given("구매 금액을 입력받으면") {
        val input = 2000
        When("로또를 생성할 때") {
            val lottos = Lottos.of(input)
            Then("1장에 1000원이다.") {
                lottos.lottoList.size shouldBe 2
            }
        }
    }
})
