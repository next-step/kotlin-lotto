package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class WinnerTicketTest : BehaviorSpec({

    Given("당첨 티켓과 일치하는 로또 티켓이 있을 때") {
        val winnerTicket = WinnerTicket.of(setOf(1, 2, 3, 4, 5, 6))
        val lottoTicket = LottoTicket.of(setOf(1, 2, 3, 4, 5, 6))

        When("매칭된 번호를 확인하는 countMatchNumbers를 호출하면") {
            val matchCount = winnerTicket.countMatchNumbers(lottoTicket)

            Then("일치하는 숫자의 갯수 6을 반환한다.") {
                matchCount shouldBe 6
            }
        }
    }
})
