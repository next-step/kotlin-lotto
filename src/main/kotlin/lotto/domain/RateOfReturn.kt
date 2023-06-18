package lotto.domain

class RateOfReturn(mRanking: Ranking, amount: Int) {
    val rate: Double
    init {
        rate = mRanking.totalWinAmount.toDouble() / amount.toDouble()
    }
}
