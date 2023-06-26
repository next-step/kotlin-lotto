package lotto.domain

import lotto.dto.LottoMatchResult
import lotto.dto.PurchasedLotteryPapers

class LottoMatcher {

    fun countLottoWinner(
        winningNumber: WinningNumber,
        purchasedLotteryPapers: PurchasedLotteryPapers
    ): LottoMatchResult {
        val winningLottoNumber = winningNumber.getWinningLottoNumber()
        val matchedCounts = getMatchedCount(winningLottoNumber, purchasedLotteryPapers.lottoNumbers)

        val prizeList = matchedCounts.map { matchedCount ->
            PrizeLevel.fromNumberOfHit(matchedCount)
        }
        return LottoMatchResult(PrizeLevel.countPrizeLevels(prizeList))
    }

    private fun getMatchedCount(winningLottoNumber: List<Int>, lottoNumbers: List<List<Int>>): List<Int> {
        return lottoNumbers.map { lottoNumber ->
            LottoNumberComparator.compare(winningLottoNumber, lottoNumber)
        }
    }
}
