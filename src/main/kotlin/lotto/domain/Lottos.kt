package lotto.domain

class Lottos(
    val lottos: List<Lotto>
) {
    private val countsMap = mutableMapOf<Int, Int>()

    fun getEqualCount(equalCount: Int) = countsMap.getOrDefault(equalCount, 0)

    fun calculateTotalPrizes(winningLotto: WinningLotto): Int {
        var totalPrizes = 0

        lottos.forEach {
            val isCatchBonus = it.isCatchBonus(winningLotto.bonusNumber)

            val equalCount = it.checkEqualCount(winningLotto)
            countsMap[equalCount] = countsMap.getOrDefault(equalCount, 0) + 1

            val prize = LottoPrizes.getMoney(equalCount, isCatchBonus)
            totalPrizes += prize
        }

        return totalPrizes
    }
}
