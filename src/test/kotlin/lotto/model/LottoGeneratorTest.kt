package lotto.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

//class LottoGeneratorTest: BehaviorSpec({
//    Given("로또 생성기") {
//        When("1에서 45사이의 6개 숫자를 가지는 10개의 로또 생성 했을 때") {
//            val tickets = LottoGenerator.generateTickets(10, 6, 1..45)
//            Then("10개의 로또 티켓이 생성된다") {
//                tickets.size shouldBe 10
//            }
//        }
//    }
//})
