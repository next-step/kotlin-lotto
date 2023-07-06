package lotto.domain

import lotto.dto.LottoMatchResult
import lotto.dto.MatchedCount
import lotto.dto.PurchasedLotteryPapers

class LottoMatcher {

    fun countLottoWinner(
        winningNumber: WinningNumber,
        purchasedLotteryPapers: PurchasedLotteryPapers,
    ): LottoMatchResult {
        val matchedCountList = getMatchedCount(winningNumber, purchasedLotteryPapers.lotteryPaperList)

        val prizeList = matchedCountList.map { matchedCount ->
            PrizeLevel.proceedLevel(matchedCount.matchedNumber, matchedCount.bonusNumberMatch)
        }
        return LottoMatchResult(LottoMatchResult.countPrizeLevels(prizeList))
    }

    private fun getMatchedCount(
        winningNumber: WinningNumber,
        lotteryPaperList: List<LotteryPaper>
    ): List<MatchedCount> {
        return lotteryPaperList.map {
            val matchedNumber = winningNumber.compareLottoNumber(it.getLottoNumbers())
            val bonusNumberMatch = winningNumber.isBonusNumberMatch(it.getLottoNumbers())
            MatchedCount(matchedNumber, bonusNumberMatch)
        }
    }
}
