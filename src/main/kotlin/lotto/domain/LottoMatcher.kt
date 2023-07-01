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
            val eachPrizeLevel = PrizeLevel.fromNumberOfHit(matchedCount.value)
            SecondLevelDiscriminator.checkPrizeLevelIsSecond(eachPrizeLevel, matchedCount.key, bonusNumber)
        }
        return LottoMatchResult(LottoMatchResult.countPrizeLevels(prizeList))
    }

    private fun getMatchedCount(
        winningLottoNumber: List<LottoNumber>,
        lotteryPaperList: List<LotteryPaper>
    ): Map<LotteryPaper, Int> {
        return lotteryPaperList.associateWith {
            LottoNumberComparator.compare(winningLottoNumber, it.getLottoNumbers())
        }
    }
}
