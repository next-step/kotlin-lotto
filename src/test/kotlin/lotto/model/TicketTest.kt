package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class TicketTest : BehaviorSpec({
    Given("티켓") {
        When("숫자 개수가 6이고 기대값이 1에서 45사이인 티켓 생성 했을때") {
            val ticket = Ticket(length = 6, range = 1..45)
            Then("6개의 숫자가 생성된다") {
                ticket.numbers.size shouldBe 6
            }
            Then("1부터 45까지의 숫자가 생성된다") {
                ticket.numbers.all { it in 1..45 } shouldBe true
            }
            Then("숫자는 중복되지 않는다") {
                ticket.numbers.size shouldBe ticket.numbers.toSet().size
            }
        }
        When("티켓번호가 1, 2, 3, 4, 5, 6인 티켓 생성 했을 때") {
            val ticket = Ticket(numbers = listOf(1, 2, 3, 4, 5, 6))
            Then("6개의 숫자가 생성된다") {
                ticket.numbers.size shouldBe 6
            }
            Then("숫자는 중복되지 않는다") {
                ticket.numbers.size shouldBe ticket.numbers.toSet().size
            }
        }
        When("티켓번호가 1, 2, 34, 34, 5, 6인 티켓 생성 했을 때") {
            Then("중복으로 인한 인자 에러가 난다") {
                shouldThrow<IllegalArgumentException> { Ticket(numbers = listOf(1, 2, 34, 34, 5, 6)) }
            }
        }
    }
    Given("티켓번호가 1, 2, 3, 4, 5, 6인 티켓") {
        val ticket = Ticket(numbers = listOf(1, 2, 3, 4, 5, 6))
        When("당첨번호가 4, 5, 6, 22, 33, 44일때") {
            val matchCount = ticket.matchCount(listOf(4, 5, 6, 22, 33, 44))
            Then("3개의 숫자가 일치") {
                matchCount shouldBe 3
            }
        }
    }
})
