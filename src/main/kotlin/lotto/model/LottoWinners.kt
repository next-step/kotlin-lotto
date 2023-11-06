package lotto.model

data class LottoWinners(
    val totalGameCount: Int,
    val countOf1st: Int = 0,
    val countOf3rd: Int = 0,
    val countOf4th: Int = 0,
    val countOf5th: Int = 0,
) {

    fun earningRate(pricePerGame: Int): Double {
        TODO()
    }

    companion object {
        private const val PRIZE_1ST = 2000000000;
        private const val PRIZE_3RD = 1500000;
        private const val PRIZE_4th = 50000;
        private const val PRIZE_5th = 5000;
        private const val PRIZE_UNIT = "원"
    }
}
