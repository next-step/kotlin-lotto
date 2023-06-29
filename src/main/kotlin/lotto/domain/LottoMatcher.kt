package lotto.domain

import lotto.dto.LottoMatchResult
import lotto.dto.PurchasedLotteryPapers

class LottoMatcher {

    fun countLottoWinner(
        winningNumber: LotteryPaper,
        purchasedLotteryPapers: PurchasedLotteryPapers,
        bonusBall: BonusBall
    ): LottoMatchResult {
        val winningLottoNumber = winningNumber.getLottoNumber()
        val matchedCountsMap = getMatchedCount(winningLottoNumber, purchasedLotteryPapers.lotteryPaperList)

        val prizeList = matchedCountsMap.map { matchedCount ->
            val eachPrizeLevel = PrizeLevel.fromNumberOfHit(matchedCount.value)
            SecondLevelDiscriminator.checkPrizeLevelIsSecond(eachPrizeLevel, matchedCount.key, bonusBall)
        }
        return LottoMatchResult(LottoMatchResult.countPrizeLevels(prizeList))
    }

    private fun getMatchedCount(
        winningLottoNumber: List<Int>,
        lotteryPaperList: List<LotteryPaper>
    ): Map<LotteryPaper, Int> {
        return lotteryPaperList.associateWith {
            LottoNumberComparator.compare(winningLottoNumber, it.getLottoNumber())
        }
    }
}
