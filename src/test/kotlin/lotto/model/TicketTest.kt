package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.collection.LottoNumber
import lotto.collection.LottoTicket

class TicketTest : BehaviorSpec({
    Given("티켓") {
        When("티켓번호가 1, 2, 3, 4, 5, 6인 티켓 생성 했을 때") {
            val lottoTicket = LottoTicket(numbers =(1..6).map { LottoNumber.from(it) })
            Then("6개의 숫자가 생성된다") {
                lottoTicket.numbers.size shouldBe 6
            }
            Then("숫자는 중복되지 않는다") {
                lottoTicket.numbers.size shouldBe lottoTicket.numbers.toSet().size
            }
        }
        When("티켓번호가 1, 2, 3, 4, 5인 티켓 생성 했을 때") {
            Then("6개의 숫자로 안 이루어져서 에러가 난다") {
                shouldThrow<IllegalArgumentException> { LottoTicket(numbers =(1..5).map { LottoNumber.from(it) }) }
            }
        }
        When("티켓번호가 1, 2, 34, 34, 5, 6인 티켓 생성 했을 때") {
            Then("중복으로 인한 인자 에러가 난다") {
                shouldThrow<IllegalArgumentException> { LottoTicket(numbers = listOf(1, 2, 34, 34, 5, 6).map { LottoNumber.from(it) }) }
            }
        }
    }
})
