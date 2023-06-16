package lotto

import java.math.BigDecimal
import java.math.RoundingMode

class WinningLottoNumber(private val winningNumber: LottoNumber) {

    fun makeRankingCountMap(lottoNumbers: LottoNumbers): Map<LottoRanking, Int> = lottoNumbers.groupingBy {
        it.getRanking(winningNumber)
    }.eachCount()

    fun getRevenueRate(lottoNumbers: LottoNumbers): BigDecimal {
        val totalWinningAmount = lottoNumbers.sumOf { it.getRanking(winningNumber).winningAmount }
        val totalPurchaseAmount = BigDecimal(lottoNumbers.size * LottoStore.PURCHASE_AMOUNT_UNIT)
        return BigDecimal(totalWinningAmount).divide(totalPurchaseAmount, 2, RoundingMode.DOWN)
    }
}
