package lotto.domain

import lotto.dto.LotteryPapers
import lotto.dto.LottoMatchResult
import lotto.dto.MatchedCount

class LottoMatcher {

    fun countLottoWinner(
        winningNumber: WinningNumber,
        lotteryPapers: LotteryPapers,
    ): LottoMatchResult {
        val matchedCountList = getMatchedCount(winningNumber, lotteryPapers.lotteryPaperList)

        val prizeList = matchedCountList.map { matchedCount ->
            PrizeLevel.proceedLevel(matchedCount)
        }
        return LottoMatchResult(LottoMatchResult.countPrizeLevels(prizeList))
    }

    private fun getMatchedCount(
        winningNumber: WinningNumber,
        lotteryPaperList: List<LotteryPaper>
    ): List<MatchedCount> {
        return lotteryPaperList.map {
            winningNumber.matchCount(it.getLottoNumbers())
        }
    }
}
