package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoGameResultTest : FunSpec({

    test("로또 게임 결과는 등수별 당첨 결과를 갖는다.") {
        val purchaseMoney = 1_000L
        val winningLottoNumbers = setOf(1, 2, 3, 4, 5, 6)
        val lottoTickets = listOf(
            LottoTicket(setOf(1, 2, 3, 4, 5, 6)),
            LottoTicket(setOf(10, 20, 30, 4, 5, 6)),
        )

        val lottoGameResult = LottoGameResult(purchaseMoney, winningLottoNumbers, lottoTickets)

        lottoGameResult.lottoTicketWinningInfos shouldBe listOf(
            LottoTicketWinningInfo(LottoPrize.FIRST, 1),
            LottoTicketWinningInfo(LottoPrize.SECOND, 0),
            LottoTicketWinningInfo(LottoPrize.THIRD, 0),
            LottoTicketWinningInfo(LottoPrize.FOURTH, 1),
        )
    }

    test("로또 게임 결과는 수익률을 갖는다.") {
        val purchaseMoney = 1_000L
        val winningLottoNumbers = setOf(1, 2, 3, 4, 5, 6)
        val lottoTickets = listOf(LottoTicket(setOf(1, 2, 3, 4, 5, 6)))

        val lottoGameResult = LottoGameResult(purchaseMoney, winningLottoNumbers, lottoTickets)

        lottoGameResult.totalRateOfReturn shouldBe LottoPrize.FIRST.prizeMoney.toDouble() / purchaseMoney.toDouble()
    }
})
