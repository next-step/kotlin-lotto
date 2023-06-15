package lotto

import lotto.LottoStore.Companion.PURCHASE_AMOUNT_UNIT
import java.math.BigDecimal
import java.math.RoundingMode

class LottoNumbers(private val lottoNumbers: List<LottoNumber>) : List<LottoNumber> by lottoNumbers {
    fun makeRankingCountMap(winLottoNumber: LottoNumber): Map<LottoRanking, Int> = lottoNumbers.groupingBy {
        it.getRanking(winLottoNumber)
    }.eachCount()

    fun getRevenueRate(winLottoNumber: LottoNumber): BigDecimal {
        val totalWinningAmount = lottoNumbers.sumOf { it.getRanking(winLottoNumber).winningAmount }
        val totalPurchaseAmount = BigDecimal(lottoNumbers.size * PURCHASE_AMOUNT_UNIT)
        return BigDecimal(totalWinningAmount).divide(totalPurchaseAmount, 2, RoundingMode.DOWN)
    }
}
