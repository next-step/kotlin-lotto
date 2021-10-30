package lotto.model

/**
 * 로또 당첨번호 비교한 통계를 위한 데이터 클래스
 * */
data class LottoStatisticFormat(
    val purchasedPrice: Price,
    val winList: HashMap<LottoRank, Int>
) {
    private val totalPrice: Int = (getRankCount(LottoRank.FIRST) * LottoRank.FIRST.winningMoney) +
        (getRankCount(LottoRank.SECOND) * LottoRank.SECOND.winningMoney) +
        (getRankCount(LottoRank.THIRD) * LottoRank.THIRD.winningMoney) +
        (getRankCount(LottoRank.FOURTH) * LottoRank.FOURTH.winningMoney)

    val profit: String = String.format(FORMAT_PROFIT, (totalPrice / purchasedPrice.value!! + totalPrice % purchasedPrice.value).toDouble())

    private fun getRankCount(rank: LottoRank): Int = winList[rank] ?: 0

    companion object {
        private const val FORMAT_PROFIT = "%.2f"
    }
}
