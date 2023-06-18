package lotto.domain

import lotto.dto.ResultDTO

object Profit {

    fun calculateLottoProfit(results: List<ResultDTO>): Int {
        return results.sumOf {
            it.matchNum * it.lottoRank.price
        }
    }

    fun calculateLottoProfitRatio(profit: Int, purchase: Int): Double {
        return (profit.toDouble() / purchase).toFormatting()
    }
}

private fun Double.toFormatting() = String.format("%.2f", this).toDouble()
