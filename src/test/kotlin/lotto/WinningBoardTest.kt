package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinningBoardTest : StringSpec({
    "당첨 보드는 로또 1등 당첨 번호(티켓)을 입력 받는다" {
        val lottoTicket = LottoTicket(numbers = listOf(1, 2, 3, 4, 5, 6))

        val sut = WinningBoard(winningTicket = lottoTicket)

        sut.winningTicket shouldBe lottoTicket
    }
})
