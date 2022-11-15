package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import lotto.domain.LottoGame
import lotto.domain.LottoTicket
import lotto.domain.LottoTicketBulk
import lotto.domain.WinnerTicket

class LottoGameTest : BehaviorSpec({

    given("당첨번호와 같은 로또 티켓이 있는 로또 게임을 생성했을 때") {
        val lottoGame = LottoGame(
            LottoTicketBulk(listOf(LottoTicket.of(setOf(1, 2, 3, 4, 5, 6)))),
            WinnerTicket.of(setOf(1, 2, 3, 4, 5, 6))
        )
        When("당첨된 티켓을 확인하면") {
            val winnerTicket = lottoGame.result()
            Then("수익률은 2000000000/1000 이다.") {
                winnerTicket.calculateProfitRate() shouldBe 2000000000.0 / 1000
            }
        }
    }

    given("로또 구입 금액 999원으로") {
        val amount = 999
        When("티켓을 구매하면") {
            Then("로또는 최소 1장 이상 구매할 수 있습니다. 메시지의 IllegalArgumentException이 발생한다.") {
                shouldThrow<IllegalArgumentException> { LottoGame.purchaseTicket(amount) }
                    .shouldHaveMessage("로또는 최소 1장 이상 구매할 수 있습니다.")
            }
        }
    }
})
