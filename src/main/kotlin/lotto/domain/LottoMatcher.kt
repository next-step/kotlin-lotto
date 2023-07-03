package lotto.domain

import lotto.dto.LottoMatchResult
import lotto.dto.PurchasedLotteryPapers

class LottoMatcher {
    private val prizeLevelDiscriminator = PrizeLevelDiscriminator()

    fun countLottoWinner(
        winningNumber: WinningNumber,
        purchasedLotteryPapers: PurchasedLotteryPapers,
    ): LottoMatchResult {
        val winningLottoNumbers = winningNumber.winningNumber.getLottoNumbers()
        val matchedCountsMap = getMatchedCount(winningLottoNumbers, purchasedLotteryPapers.lotteryPaperList)

        val prizeList = matchedCountsMap.map { matchedCount ->
            val prizeLevel = PrizeLevel.fromNumberOfHit(matchedCount.value)
            prizeLevelDiscriminator.checkIsThirdLevel(prizeLevel, Pair(matchedCount.key, winningNumber.bonusNumber))
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
