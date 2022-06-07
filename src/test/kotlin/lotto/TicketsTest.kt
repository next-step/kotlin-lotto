package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Tickets
import lotto.domain.WinnerLotto
import lotto.domain.Winning

class TicketsTest : FreeSpec({
    "로또티켓들은" - {
        val tickets = Tickets(
            listOf(
                Lotto.of(setOf(1, 2, 7, 8, 9, 10)),
                Lotto.of(setOf(1, 2, 3, 7, 8, 9)),
                Lotto.of(setOf(1, 2, 3, 4, 8, 9)),
                Lotto.of(setOf(1, 2, 3, 6, 8, 9)),
                Lotto.of(setOf(1, 2, 3, 4, 5, 9)),
                Lotto.of(setOf(1, 2, 3, 4, 5, 10)),
                Lotto.of(setOf(1, 2, 3, 4, 5, 6)),
            )
        )

        val pastWinner = Lotto.of(setOf(1, 2, 3, 4, 5, 6))
        val bonus = LottoNumber(10)
        val winner = WinnerLotto(pastWinner, bonus)

        "2개 이하로 일치하는 꽝의 개수를 출력한다." {
            tickets.getResult(winner).getWinningCount(Winning.LOSE) shouldBe 1
        }
        "3개 일치하는 5등의 개수를 출력한다." {
            tickets.getResult(winner).getWinningCount(Winning.FIFTH_PLACE) shouldBe 1
        }
        "4개 일치하는 4등의 개수를 출력한다." {
            tickets.getResult(winner).getWinningCount(Winning.FOURTH_PLACE) shouldBe 2
        }
        "5개 일치하는 3등의 개수를 출력한다." {
            tickets.getResult(winner).getWinningCount(Winning.THIRD_PLACE) shouldBe 1
        }
        "5개 일치하고 보너스 번호도 일치하는 2등의 개수를 출력한다." {
            tickets.getResult(winner).getWinningCount(Winning.SECOND_PLACE) shouldBe 1
        }
        "6개 일치하는 1등의 개수를 출력한다." {
            tickets.getResult(winner).getWinningCount(Winning.FIRST_PLACE) shouldBe 1
        }
    }
})
