package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoGameResultTest : FunSpec({

    test("로또 게임 결과는 등수별 당첨 결과를 갖는다.") {
        val purchaseMoney = 1_000L
        val winningLottoNumbers = LottoNumbers.of(setOf(1, 2, 3, 4, 5, 6))
        val lottoTickets = listOf(
            LottoTicket.of(setOf(1, 2, 3, 4, 5, 6)),
            LottoTicket.of(setOf(10, 20, 30, 4, 5, 6)),
        )

        val lottoGameResult = LottoGameResult(purchaseMoney, winningLottoNumbers, lottoTickets)

        lottoGameResult.getWinningLottoTicketCountBy(LottoPrize.FIRST) shouldBe 1
        lottoGameResult.getWinningLottoTicketCountBy(LottoPrize.SECOND) shouldBe 0
        lottoGameResult.getWinningLottoTicketCountBy(LottoPrize.THIRD) shouldBe 0
        lottoGameResult.getWinningLottoTicketCountBy(LottoPrize.FOURTH) shouldBe 1
    }

    test("구입 금액 1000원으로 1등에 당첨되었다면 수익률은 2000000이다.") {
        val purchaseMoney = 1_000L
        val winningLottoNumbers = LottoNumbers.of(setOf(1, 2, 3, 4, 5, 6))
        val lottoTickets = listOf(LottoTicket.of(setOf(1, 2, 3, 4, 5, 6)))

        val lottoGameResult = LottoGameResult(purchaseMoney, winningLottoNumbers, lottoTickets)

        lottoGameResult.totalRateOfReturn shouldBe 2000000.0
    }
})
