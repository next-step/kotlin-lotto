package lotto.model

import lotto.model.LottoStatisticFormat.Companion.getRankProfit

/**
 * 로또 당첨번호 비교한 통계를 위한 데이터 클래스
 * */
data class LottoStatisticFormat(
    val purchasedPrice: Price,
    val winList: HashMap<LottoRank, Int>,
) {
    val profit: Double = ((getTotalPrice(winList) / purchasedPrice.price).toFloat()).toDouble()

    companion object {
        fun HashMap<LottoRank, Int>.getRankCount(rank: LottoRank): Int = this[rank] ?: 0
        fun HashMap<LottoRank, Int>.getRankProfit(rank: LottoRank): Int = (getRankCount(rank) * rank.winningMoney)
        fun getTotalPrice(winList: HashMap<LottoRank, Int>): Int = LottoRank
            .values()
            .filter { it != LottoRank.MISS }
            .sumOf {  winList.getRankProfit(it) }
    }
}
