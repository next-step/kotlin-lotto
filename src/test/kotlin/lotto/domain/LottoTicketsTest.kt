package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

internal class LottoTicketsTest : FreeSpec({

    "로또들을 당첨 등수별로 나누어서 반환한다." {
        // given
        val winningTicket = WinningTicket.of(listOf(1, 2, 3, 4, 5, 6))

        // TODO: 2022/06/20 리팩터링 대상
        val lottoTicket1 = LottoTicket(LottoNumbersFixture.of(setOf(1, 2, 3, 4, 5, 6)), bonusNumber = LottoNumber.from(13))
        val lottoTicket2 = LottoTicket(LottoNumbersFixture.of(setOf(1, 2, 3, 4, 5, 9)), bonusNumber = LottoNumber.from(13))
        val lottoTicket3 = LottoTicket(LottoNumbersFixture.of(setOf(1, 2, 3, 4, 9, 10)), bonusNumber = LottoNumber.from(13))
        val lottoTicket4 = LottoTicket(LottoNumbersFixture.of(setOf(1, 12, 5, 9, 45, 7)), bonusNumber = LottoNumber.from(13))

        val lottoTickets = LottoTickets(listOf(lottoTicket1, lottoTicket2, lottoTicket3, lottoTicket4))

        // when
        val results = lottoTickets.totalMatchResults(winningTicket = winningTicket)

        // then
        results.amountWithWinnings[WinningAmount.MISS] shouldBe 1
        results.amountWithWinnings[WinningAmount.FOURTH] shouldBe 0
        results.amountWithWinnings[WinningAmount.THIRD] shouldBe 1
        results.amountWithWinnings[WinningAmount.SECOND] shouldBe 1
        results.amountWithWinnings[WinningAmount.FIRST] shouldBe 1
    }
})
