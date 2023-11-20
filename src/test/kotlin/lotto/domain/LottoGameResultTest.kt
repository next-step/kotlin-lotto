package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoGameResultTest : FunSpec({

    test("로또 게임 결과는 등수별 당첨 결과를 갖는다.") {
        val purchaseMoney = 1_000L
        val winningLottoNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6)
        val lottoTickets = listOf(
            LottoTicket.of(1, 2, 3, 4, 5, 6),
            LottoTicket.of(10, 20, 30, 4, 5, 6),
        )

        val lottoGameResult = LottoGameResult(purchaseMoney, winningLottoNumbers, lottoTickets)

        lottoGameResult.lottoTicketWinningResults shouldBe listOf(
            LottoTicketWinningResult(LottoPrize.FIRST, 1),
            LottoTicketWinningResult(LottoPrize.SECOND, 0),
            LottoTicketWinningResult(LottoPrize.THIRD, 0),
            LottoTicketWinningResult(LottoPrize.FOURTH, 1),
        )
    }

    test("로또 게임 결과는 수익률을 갖는다.") {
        val purchaseMoney = 1_000L
        val winningLottoNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6)
        val lottoTickets = listOf(LottoTicket.of(1, 2, 3, 4, 5, 6))

        val lottoGameResult = LottoGameResult(purchaseMoney, winningLottoNumbers, lottoTickets)

        lottoGameResult.totalRateOfReturn shouldBe LottoPrize.FIRST.prizeMoney.toDouble() / purchaseMoney.toDouble()
    }
})
