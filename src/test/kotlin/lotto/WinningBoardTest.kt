package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class WinningBoardTest : StringSpec({
    "당첨 보드는 로또 1등 당첨 번호(티켓)을 입력 받는다" {
        val lottoTicket = LottoTicket(numbers = listOf(1, 2, 3, 4, 5, 6))

        val sut = WinningBoard(winningTicket = lottoTicket)

        sut.winningTicket shouldBe lottoTicket
    }

    "당첨 보드는 로또 티켓을 받아 1등 티켓과 일치하는 당첨 번호 수를 알 수 있다" {
        val sut = WinningBoard(winningTicket = LottoTicket(listOf(1, 2, 3, 4, 5, 6)))

        forAll(
            row(LottoTicket(numbers = listOf(1, 2, 3, 4, 5, 6)), 6),
            row(LottoTicket(numbers = listOf(2, 3, 4, 5, 6, 7)), 5),
            row(LottoTicket(numbers = listOf(3, 4, 5, 6, 7, 8)), 4),
            row(LottoTicket(numbers = listOf(4, 5, 6, 7, 8, 9)), 3),
            row(LottoTicket(numbers = listOf(5, 6, 7, 8, 9, 10)), 2),
            row(LottoTicket(numbers = listOf(6, 7, 8, 9, 10, 11)), 1),
            row(LottoTicket(numbers = listOf(7, 8, 9, 10, 11, 12)), 0),
        ) { lottoTicket, expectedCountOfMatch ->
            val countOfMatch = sut.checkTicket(lottoTicket)
            countOfMatch shouldBe expectedCountOfMatch
        }
    }
})
