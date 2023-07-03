package lotto.service

object LottoCalculator {

    fun calculatePrizeMoney(matchCount: Int): Long {
        return when (matchCount) {
            3 -> 5_000
            4 -> 50_000
            5 -> 1_500_000
            6 -> 2_000_000_000
            else -> 0
        }
    }

    fun calculateProfitRate(totalPrizeMoney: Long, purchaseMoney: Long): Double {
        return totalPrizeMoney.toDouble() / purchaseMoney.toDouble()
    }
}
