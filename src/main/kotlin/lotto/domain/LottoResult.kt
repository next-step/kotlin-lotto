package lotto.domain

class LottoResult(
    val matchCountByRank: Map<LottoRank, Int>
) {

    fun calculateEarningRate(buyingPrice: LottoBuyingPrice): Double {
        val earningMoney = matchCountByRank.map { (rank, _) ->
            val winningMoney = rank.winningMoney
            val matchCount = matchCountByRank[rank] ?: 0
            winningMoney.times(matchCount).toLong()
        }.sum()
        return earningMoney.toDouble().div(buyingPrice.value)
    }
}
