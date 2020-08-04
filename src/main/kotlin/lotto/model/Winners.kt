package lotto.model

class Winners(
    list: List<Prize>
) {
    val lottoBuyCount: Int = list.size
    private val winLotto: Map<Prize, Int> = list.groupingBy { it }.eachCount()

    fun getPrizeCount(prize: Prize) = winLotto.getOrDefault(prize, Prize.ZERO.prizeMoney)

    fun getTotalYield() = getTotalPrizeMoney() / (lottoBuyCount * Lotto.PRICE).toDouble()

    private fun getTotalPrizeMoney() = Prize.values().sumBy { it.prizeMoney * getPrizeCount(it) }
}
