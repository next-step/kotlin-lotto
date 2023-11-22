package lotto.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoGeneratorTest : BehaviorSpec({
    Given("로또 생성기") {
        When("8개의 로또의 자동 로또를 생성할 때") {
            val tickets = LottoGenerator.generateAutoTickets(8)
            Then("8개의 자동 로또 티켓이 생성된다") {
                tickets.size shouldBe 8
            }
        }
    }
})
