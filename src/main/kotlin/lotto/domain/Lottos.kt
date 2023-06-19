package lotto.domain

class Lottos(
    val lottos: List<Lotto>
) {
    private val countsMap = mutableMapOf<Int, Int>()

    fun getEqualCount(equalCount: Int) = countsMap.getOrDefault(equalCount, 0)

    fun calculateTotalPrizes(winningLotto: Lotto): Int {
        var totalPrizes = 0

        lottos.forEach {
            val equalCount = winningLotto.checkEqualCount(it)
            countsMap[equalCount] = countsMap.getOrDefault(equalCount, 0) + 1

            val prize = LottoPrizes.getMoney(equalCount)
            totalPrizes += prize
        }

        return totalPrizes
    }
}
