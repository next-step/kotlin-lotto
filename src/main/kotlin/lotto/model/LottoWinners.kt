package lotto.model

data class LottoWinners(
    val totalGameCount: Int,
    val countOf1st: Int = 0,
    val countOf3rd: Int = 0,
    val countOf4th: Int = 0,
    val countOf5th: Int = 0,
) {

    fun earningRate(pricePerGame: Int): Pair<Double, String> {
        val rate = earnAmount().toDouble() / (pricePerGame.toDouble() * totalGameCount)
        return Pair(
            rate,
            when (rate > 1.toDouble()) {
                true -> "이익"
                false -> "손해"
            }
        )

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
        private const val PRIZE_UNIT: String = "원"
    }
}
