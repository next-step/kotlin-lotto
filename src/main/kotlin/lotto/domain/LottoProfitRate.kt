package lotto.domain

object LottoProfitRate {
    fun calculateProfitRate(buyingPrice: Int, winningLottoStatistics: WinningLottoStatistics): Double {
        var sum = 0.0
        winningLottoStatistics.statistics.forEach {
            sum += it.key.winningMoney * it.value
        }

        return sum / buyingPrice.toDouble()
    }
}
