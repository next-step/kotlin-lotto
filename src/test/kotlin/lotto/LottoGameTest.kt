package lotto

import io.kotest.core.spec.style.BehaviorSpec

class LottoGameTest : BehaviorSpec({

    given("당첨번호와 같은 로또 티켓이 있는 로또 게임을 생성했을 때"){
        val lottoGame = LottoGame(
            listOf( LottoTicket.of(setOf(1,2,3,4,5,6))),
            WinnerTicket.of(setOf(1,2,3,4,5,6))
        )
        When("수익률은"){
            val yield = lottoGame.calculateYield()
            Then("2000000000/1000 이다."){
                yield shouldBe 2000000000/1000
            }
        }
    }
})
