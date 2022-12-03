package lotto.domain

class WinningLottoStatistics(
    private val winningLotto: WinningLotto
) {

    fun getWinningStatistics(lottoList: LottoList): LottoMatchList {
        val lottoMatchList = lottoList.compare(winningLotto)
            .groupBy { it }
            .map { lottoMap ->
                LottoMatch(lottoMap.key, lottoMap.value.count().toLong())
            }
        return LottoMatchList(lottoMatchList.toMutableList())
    }

    fun getProfit(totalPrice: Long, lottMatchList: LottoMatchList): Double {
        // 총 이득
        val totalReward = lottMatchList.sumLottoMatchProfit()

        val profit = totalReward / totalPrice.toDouble()

        return (profit * DIGIT_NUMBER).toInt() / DIGIT_NUMBER
    }

    fun isProfitable(profit: Double) = profit >= STANDARD_PROFIT_RATIO

    companion object {
        private const val DIGIT_NUMBER = 100.0
        const val STANDARD_PROFIT_RATIO = 1
    }
}
