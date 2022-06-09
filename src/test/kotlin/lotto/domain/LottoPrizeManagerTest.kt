package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoPrizeManagerTest : DescribeSpec({

    it("당첨 통계를 알수 있습니다") {
        // given
        val lottoPrizeManager = LottoPrizeManager()
        val allMatchedWinningLottoInts = listOf(1, 2, 3, 4, 5, 6)
        val threeMatchedWinningLottoInts = mutableListOf(21, 22, 23)
        threeMatchedWinningLottoInts.addAll(allMatchedWinningLottoInts.take(3))
        val bonusLottoNumber = LottoTicketNumber(7)
        val winningLottoNumbers =
            WinningLottoNumbers(LottoTicketNumbers.ofInts(allMatchedWinningLottoInts), bonusLottoNumber)
        val lottoTickets: List<LottoTicket> = listOf<LottoTicket>(
            LottoTicket.ofInts(allMatchedWinningLottoInts),
            LottoTicket.ofInts(allMatchedWinningLottoInts),
            LottoTicket.ofInts(allMatchedWinningLottoInts),
            LottoTicket.ofInts(threeMatchedWinningLottoInts),
            LottoTicket.ofInts(threeMatchedWinningLottoInts),
            LottoTicket.ofInts(listOf(1, 2, 20, 21, 22, 23)),
        )

        // when
        val winningStats = lottoPrizeManager.getWinningStats(lottoTickets, winningLottoNumbers)

        // then
        // 6개 번호 일치한 당첨 정책 확인
        winningStats[0].lottoPrizePolicy.winningNumberMatchCount shouldBe 6
        winningStats[0].lottoPrizePolicy.wonPrize shouldBe Money(60000)
        winningStats[0].totalWinningCount shouldBe 3
        winningStats[0].totalWinningPrize shouldBe Money(3 * 60000)

        // 3개 일치한 당첨 정책 확인
        winningStats[1].lottoPrizePolicy.winningNumberMatchCount shouldBe 3
        winningStats[1].lottoPrizePolicy.wonPrize shouldBe Money(30000)
        winningStats[1].totalWinningCount shouldBe 2
        winningStats[1].totalWinningPrize shouldBe Money(2 * 30000)
    }
})
