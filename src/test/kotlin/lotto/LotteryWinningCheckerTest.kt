package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LotteryWinningCheckerTest : StringSpec({
    "로또 당첨 검사기는 로또 1등 당첨 번호(티켓)을 입력 받는다" {
        val lottoTicket = LottoTicket(numbers = listOf(1, 2, 3, 4, 5, 6))

        val sut = LotteryWinningChecker(winningTicket = lottoTicket)

        sut.winningTicket shouldBe lottoTicket
    }

    "로또 당첨 검사기는 로또 티켓을 받아 당첨 결과를 조회할 수 있다" {
        val sut = LotteryWinningChecker(winningTicket = LottoTicket(listOf(1, 2, 3, 4, 5, 6)))

        forAll(
            row(LottoTicket(numbers = listOf(1, 2, 3, 4, 5, 6)), WinningResult.FIRST),
            row(LottoTicket(numbers = listOf(2, 3, 4, 5, 6, 7)), WinningResult.SECOND),
            row(LottoTicket(numbers = listOf(3, 4, 5, 6, 7, 8)), WinningResult.THIRD),
            row(LottoTicket(numbers = listOf(4, 5, 6, 7, 8, 9)), WinningResult.FOURTH),
            row(LottoTicket(numbers = listOf(5, 6, 7, 8, 9, 10)), WinningResult.LOSE),
            row(LottoTicket(numbers = listOf(6, 7, 8, 9, 10, 11)), WinningResult.LOSE),
            row(LottoTicket(numbers = listOf(7, 8, 9, 10, 11, 12)), WinningResult.LOSE),
        ) { lottoTicket, expectedResult ->
            val winningResult = sut.checkTicket(lottoTicket)
            winningResult shouldBe expectedResult
        }
    }
})
