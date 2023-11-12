package lotto.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoPersonTest: BehaviorSpec({
    Given("10000원을 가진 로또 인간") {
        val lottoPerson = LottoPerson(10000)
        When("생성될 때") {
            Then("10장의 로또 티켓을 가진다") {
                lottoPerson.lottoTickets.size shouldBe 10
            }
        }
    }
})
