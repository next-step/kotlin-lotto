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
        TODO()
//        return winningCountBy
//            .values
//            .sum()
//        (PRIZE_1ST * countOf1st) +
//            (PRIZE_3RD * countOf3rd) +
//            (PRIZE_4th * countOf4th) +
//            (PRIZE_5th * countOf5th)
    }

    companion object {
        const val BENEFIT_LOSS_CROSS_POINT: Double = 1.00
        const val BENEFIT_MESSAGE: String = "이익"
        const val LOSS_MESSAGE: String = "손해"
    }
}
