package lotto.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoPersonTest: BehaviorSpec({
    Given("10000원을 가진 로또 인간") {
        val lottoPerson = LottoPerson(LottoGenerator)
        When("로또를 구입할 때") {
            val lottoTickets = lottoPerson.buyLottoTickets(10000, emptyList())
            Then("10장의 로또 티켓을 가진다") {
                lottoTickets.size shouldBe 10
            }
        }
    }
})
