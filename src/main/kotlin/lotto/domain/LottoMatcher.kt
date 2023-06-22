package lotto.domain

import lotto.dto.LottoResponse

class LottoMatcher {

    fun countLottoWinner(winningNumber: WinningNumber, lottoResponse: LottoResponse): Map<PrizeLevel, Int> {
        val winningLottoNumber = winningNumber.getWinningLottoNumber()
        val matchedCounts = getMatchedCount(winningLottoNumber, lottoResponse.lottoNumbers)

        val prizeList = matchedCounts.map { matchedCount ->
            PrizeLevel.fromNumberOfHit(matchedCount)
        }
        return PrizeLevel.countPrizeLevels(prizeList)
    }

    private fun getMatchedCount(winningLottoNumber: List<Int>, lottoNumbers: List<List<Int>>): List<Int> {
        return lottoNumbers.map { lottoNumber ->
            LottoNumberComparator.compare(winningLottoNumber, lottoNumber)
        }
    }
}
