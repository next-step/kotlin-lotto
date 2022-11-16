package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoTicket
import lotto.domain.WinnerTicket

class WinnerTicketTest : BehaviorSpec({

    Given("당첨 티켓과 일치하는 로또 티켓이 있을 때") {
        val winnerTicket = WinnerTicket.of(setOf(1, 2, 3, 4, 5, 6), 7)
        val lottoTicket = LottoTicket.of(setOf(1, 2, 3, 4, 5, 6))

        When("매칭된 로또의 결과를 확인하는 drawResult를 호출하면") {
            val lottoResult = winnerTicket.drawResult(lottoTicket)

            Then("일치하는 숫자의 갯수 6을 반환한다.") {
                lottoResult.matchCount shouldBe 6
            }
        }
    }
    Given("당첨 번호 5자리와 보너스 번호가 일치하는 로또 티켓이 있을 때") {
        val winnerTicket = WinnerTicket.of(setOf(1, 2, 3, 4, 5, 6), 7)
        val lottoTicket = LottoTicket.of(setOf(1, 2, 3, 4, 5, 7))

        When("매칭된 로또의 결과를 확인하는 drawResult를 호출하면") {
            val lottoResult = winnerTicket.drawResult(lottoTicket)

            Then("일치하는 숫자의 갯수 5을 반환한다.") {
                lottoResult.matchCount shouldBe 5
                lottoResult.matchBonus shouldBe true
            }
        }
    }
})
