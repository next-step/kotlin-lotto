package lotto

import java.math.BigDecimal
import java.math.RoundingMode

class WinningLottoNumber(
    private val winningNumber: LottoNumber,
    private val bonusBallNumber: Int
) {

    fun makeRankingCountMap(lottoNumbers: LottoNumbers): Map<LottoRanking, Int> = lottoNumbers.groupingBy {
        this.getRanking(it)
    }.eachCount()

    fun getRevenueRate(lottoNumbers: LottoNumbers): BigDecimal {
        val totalWinningAmount = lottoNumbers.sumOf { this.getRanking(it).winningAmount }
        val totalPurchaseAmount = BigDecimal(lottoNumbers.size * LottoStore.PURCHASE_AMOUNT_UNIT)
        return BigDecimal(totalWinningAmount).divide(totalPurchaseAmount, 2, RoundingMode.DOWN)
    }

    fun getRanking(lottoNumber: LottoNumber): LottoRanking {
        val matchCount = lottoNumber.count { winningNumber.contains(it) }
        val matchBonus = lottoNumber.any { it == bonusBallNumber }
        return LottoRanking.valueOf(matchCount, matchBonus)
    }
}
