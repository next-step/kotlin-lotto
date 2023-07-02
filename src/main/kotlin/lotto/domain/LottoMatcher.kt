package lotto.domain

import lotto.dto.LottoMatchResult
import lotto.dto.PurchasedLotteryPapers

class LottoMatcher {

    fun countLottoWinner(
        winningNumber: LotteryPaper,
        purchasedLotteryPapers: PurchasedLotteryPapers,
        bonusNumber: LottoNumber
    ): LottoMatchResult {
        val winningLottoNumbers = winningNumber.getLottoNumbers()
        val matchedCountsMap = getMatchedCount(winningLottoNumbers, purchasedLotteryPapers.lotteryPaperList)

        val prizeList = matchedCountsMap.map { matchedCount ->
            PrizeLevel.fromNumberOfHit(matchedCount.value, matchedCount.key, bonusNumber)
        }
        return LottoMatchResult(LottoMatchResult.countPrizeLevels(prizeList))
    }

    private fun getMatchedCount(
        winningLottoNumbers: List<LottoNumber>,
        lotteryPaperList: List<LotteryPaper>
    ): Map<LotteryPaper, Int> {
        return lotteryPaperList.associateWith {
            LottoNumberComparator.compare(winningLottoNumbers, it.getLottoNumbers())
        }
    }
}
