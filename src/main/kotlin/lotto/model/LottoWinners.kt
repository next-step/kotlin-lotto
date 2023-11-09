package lotto.model

data class LottoWinners(
    val totalGameCount: Int,
    val countOf1st: Int = 0,
    val countOf3rd: Int = 0,
    val countOf4th: Int = 0,
    val countOf5th: Int = 0,
) {

    fun earningRate(pricePerGame: Int): Double {
        return earnAmount().toDouble() / (pricePerGame.toDouble() * totalGameCount)
    }

    private fun earnAmount(): Int {
        return (PRIZE_1ST * countOf1st) +
            (PRIZE_3RD * countOf3rd) +
            (PRIZE_4th * countOf4th) +
            (PRIZE_5th * countOf5th)
    }

    companion object {
        private const val PRIZE_1ST: Int = 2000000000
        private const val PRIZE_3RD: Int = 1500000
        private const val PRIZE_4th: Int = 50000
        private const val PRIZE_5th: Int = 5000
        const val BENEFIT_LOSS_CROSS_POINT: Double = 1.00
        const val BENEFIT_MESSAGE: String = "이익"
        const val LOSS_MESSAGE: String = "손해"
    }
}
