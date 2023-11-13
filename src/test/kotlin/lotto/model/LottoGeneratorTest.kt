package lotto.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoGeneratorTest : BehaviorSpec({
    Given("로또 생성기") {
        When("10개의 로또를 구입하기를 원하는데 2장이 수동일 때") {
            val tickets = LottoGenerator.generateTickets(10, 2) { listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) }
            Then("8개의 자동 로또 티켓이 생성된다") {
                tickets.size shouldBe 8
            }
        }
    }
})
