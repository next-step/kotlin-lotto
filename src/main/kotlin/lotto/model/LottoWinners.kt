package lotto.model

data class LottoWinners(
    val totalGameCount: Int,
    val winningCountBy: Map<Rank, Int> = emptyMap()
) {

    constructor(totalGameCount: Int, vararg winners: Pair<Rank, Int>) :
        this(totalGameCount, winners.toMap())

    fun earningRate(pricePerGame: Int): Double {
        return earnAmount().toDouble() / (pricePerGame.toDouble() * totalGameCount)
    }

    fun countOfRank(rank: Rank): Int {
        return winningCountBy.getOrDefault(rank, 0)
    }

    private fun earnAmount(): Int {
        return winningCountBy
            .keys
            .sumOf { it.totalPrizeOf(winningCountBy.getOrDefault(it, 0)) }
    }

    companion object {
        const val BENEFIT_LOSS_CROSS_POINT: Double = 1.00
        const val BENEFIT_MESSAGE: String = "이익"
        const val LOSS_MESSAGE: String = "손해"
    }
}
