package lotto.model

/**
 * 로또 당첨번호 비교한 통계를 위한 데이터 클래스
 * */
data class LottoStatisticFormat(
    val purchasedPrice: Price,
    val winList: HashMap<LottoRank, Int>,
) {
    val profit: Double = ((getTotalPrice(winList) / purchasedPrice.price).toFloat()).toDouble()

    companion object {
        fun getTotalPrice(winList: HashMap<LottoRank, Int>): Int = LottoRank
            .values()
            .filter { it.winningMoney != 0 }
            .sumOf { LottoRank.getRankProfit(winList, it) }
    }
}
