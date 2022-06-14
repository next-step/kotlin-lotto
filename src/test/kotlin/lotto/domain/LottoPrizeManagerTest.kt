package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoPrizeManagerTest : DescribeSpec({

    it("당첨 통계를 알수 있습니다") {
        // given
        val lottoPrizeManager = LottoPrizeManager()
        val allMatchedWinningLottoInts = listOf(1, 2, 3, 4, 5, 6)
        val bonusLottoNumber = LottoTicketNumber(7)

        val oneRankLottoNumber = allMatchedWinningLottoInts.toList()
        val twoRankLottoNumber: MutableList<Int> = mutableListOf()
        twoRankLottoNumber.addAll(allMatchedWinningLottoInts.take(5))
        twoRankLottoNumber.add(bonusLottoNumber.value)

        val winningLottoNumbers =
            WinningLottoNumbers(LottoTicketNumbers.ofInts(allMatchedWinningLottoInts), bonusLottoNumber)
        val lottoTickets: List<LottoTicket> = listOf(
            LottoTicket.ofInts(oneRankLottoNumber),
            LottoTicket.ofInts(twoRankLottoNumber)
        )

        // when
        val winningStats = lottoPrizeManager.getWinningStats(lottoTickets, winningLottoNumbers)

        // then
        // 6개 번호 일치한 당첨 정책 확인
        winningStats[0].lottoPrizePolicy.winningNumberMatchCount shouldBe 6
        winningStats[0].totalWinningCount shouldBe 1
        winningStats[0].totalWinningPrize shouldBe Money(1 * winningStats[0].lottoPrizePolicy.wonPrize.value)

        // 5개 일치한 당첨 정책 확인
        winningStats[1].lottoPrizePolicy.winningNumberMatchCount shouldBe 5
        winningStats[1].totalWinningCount shouldBe 1
        winningStats[1].totalWinningPrize shouldBe Money(1 * winningStats[1].lottoPrizePolicy.wonPrize.value)
    }
})
