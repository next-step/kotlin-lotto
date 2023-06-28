package lotto.domain

import lotto.dto.LottoMatchResult
import lotto.dto.PurchasedLotteryPapers

class LottoMatcher {

    fun countLottoWinner(
        winningNumber: LotteryPaper,
        purchasedLotteryPapers: PurchasedLotteryPapers
    ): LottoMatchResult {
        val winningLottoNumber = winningNumber.getLottoNumber()
        val matchedCounts = getMatchedCount(winningLottoNumber, purchasedLotteryPapers.lotteryPaperList)

        val prizeList = matchedCounts.map { matchedCount ->
            PrizeLevel.fromNumberOfHit(matchedCount)
        }
        return LottoMatchResult(LottoMatchResult.countPrizeLevels(prizeList))
    }

    private fun getMatchedCount(winningLottoNumber: List<Int>, lotteryPaperList: List<LotteryPaper>): List<Int> {
        return lotteryPaperList.map {
            LottoNumberComparator.compare(winningLottoNumber, it.getLottoNumber())
        }
    }
}
