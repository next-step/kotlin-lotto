package lotto.domain

class LottoStatistics(
    val totalPurchaseAmount: Int,
    val winningStatistics: WinningStatistics,
) {

    fun getFirstRankCount(): Int {
        return winningStatistics.getFirstRankCount()
    }

    fun getSecondRankCount(): Int {
        return winningStatistics.getSecondRankCount()
    }

    fun getThirdRankCount(): Int {
        return winningStatistics.getThirdRankCount()
    }

    fun getFourthRankCount(): Int {
        return winningStatistics.getFourthRankCount()
    }

    fun getYield(): Double {
        return winningStatistics.getTotalReward() / totalPurchaseAmount
    }
}
