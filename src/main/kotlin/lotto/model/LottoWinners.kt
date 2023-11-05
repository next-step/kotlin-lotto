package lotto.model

data class LottoWinners(
    val totalGameCount: Int,
    val countOf5th: Int,
    val countOf4th: Int,
    val countOf3rd: Int,
    val countOf1st: Int,
) {

    fun earningRate(pricePerGame: Int): Double {
        TODO()
    }
}
