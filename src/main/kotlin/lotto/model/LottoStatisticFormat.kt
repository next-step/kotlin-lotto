package lotto.model

/**
 * 로또 당첨번호 비교한 통계를 위한 데이터 클래스
 * */
data class LottoStatisticFormat(
    val purchasedPrice: Price,
    val winList: HashMap<LottoRank, Int>,
) {
    private val totalPrice: Int = LottoRank
        .values()
        .filter { it != LottoRank.MISS }
        .sumOf { getRankProfit(it) }

    val profit: Double = ((totalPrice / purchasedPrice.price).toFloat()).toDouble()

    private fun getRankCount(rank: LottoRank): Int = winList[rank] ?: 0

    private fun getRankProfit(rank: LottoRank): Int = (getRankCount(rank) * rank.winningMoney)
}
