package lotto.domain.lottoticket

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoTicket
import lotto.domain.WinningAmount
import lotto.domain.WinningTicket

internal class LottoTicketsTest : FreeSpec({

    "로또들을 당첨 등수별로 나누어서 반환한다." {
        // given
        val winningTicket = WinningTicket.of(listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7)

        val lottoTicket1 = LottoTicket(1, 2, 3, 4, 5, 6)
        val lottoTicket2 = LottoTicket(1, 2, 3, 4, 5, 9)
        val lottoTicket3 = LottoTicket(1, 2, 3, 4, 9, 10)
        val lottoTicket4 = LottoTicket(1, 12, 5, 9, 45, 7)

        val lottoTickets = LottoTickets(listOf(lottoTicket1, lottoTicket2, lottoTicket3, lottoTicket4))

        // when
        val results = lottoTickets.totalMatchResults(winningTicket = winningTicket)

        // then
        results.amountWithWinnings[WinningAmount.MISS] shouldBe 1
        results.amountWithWinnings[WinningAmount.FIFTH] shouldBe 0
        results.amountWithWinnings[WinningAmount.FOURTH] shouldBe 1
        results.amountWithWinnings[WinningAmount.THIRD] shouldBe 1
        results.amountWithWinnings[WinningAmount.SECOND] shouldBe 0
        results.amountWithWinnings[WinningAmount.FIRST] shouldBe 1
    }
})
