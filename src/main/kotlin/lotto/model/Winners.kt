package lotto.model

class Winners(
    private var list: List<Prize>
) {
    private val lottoBuyCount: Int = list.size

    fun getWinnerType(type: Prize.PrizeMoney) = list.filter { it.isType(type) }

    fun getTotalYield() = list.sumBy(Prize::getPrizeMoney).toDouble() / (lottoBuyCount * Lotto.PRICE).toDouble()
}
