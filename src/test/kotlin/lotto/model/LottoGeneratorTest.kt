package lotto.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoGeneratorTest : BehaviorSpec({
    Given("로또 생성기") {
        When("10개의 로또 생성 했을 때") {
            val tickets = LottoGenerator.generateTickets(10) { listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) }
            Then("10개의 로또 티켓이 생성된다") {
                tickets.size shouldBe 10
            }
        }
    }
})
