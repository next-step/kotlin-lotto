package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoCalculator {
    private fun calculateLottoRankList(lottoRankList: List<LottoRank>): Double = lottoRankList.sumOf { it.winningMoney.toDouble() }

    fun calculateReturnOnInvestment(lottoRankList: List<LottoRank>, buyingPrice: Double): Double {
        val totalWinningMoney: Double = this.calculateLottoRankList(lottoRankList)
        val returnOnInvestment: Double = (totalWinningMoney - buyingPrice) / buyingPrice

        return BigDecimal(returnOnInvestment).setScale(2, RoundingMode.HALF_EVEN).toDouble()
    }
}
