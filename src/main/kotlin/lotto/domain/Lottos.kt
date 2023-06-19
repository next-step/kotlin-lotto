package lotto.domain

class Lottos(
    val lottos: List<Lotto>
) {
    fun calculateStatistics(winningLotto: WinningLotto, budget: Int): LottosStatisticsVO {
        val prizeMap = generateWinningMap(winningLotto)
        val totalPrizeMoney = calculateTotalPrizeMoney(prizeMap)
        val rateOfReturn = totalPrizeMoney.toDouble() / budget.toDouble()

        return LottosStatisticsVO(prizeMap, totalPrizeMoney, rateOfReturn)
    }

    private fun generateWinningMap(winningLotto: WinningLotto): Map<LottoPrizes, Int> {
        val map = mutableMapOf<LottoPrizes, Int>()

        lottos.forEach { lotto ->
            val equalCount = lotto.checkEqualCount(winningLotto)
            val isCatchBonus = lotto.isCatchBonus(winningLotto.bonusNumber)
            val prize = LottoPrizes.of(equalCount, isCatchBonus)

            map[prize] = map.getOrDefault(prize, 0) + 1
        }

        return map
    }

    private fun calculateTotalPrizeMoney(prizeMap: Map<LottoPrizes, Int>): Int {
        var totalPrizeMoney = 0

        prizeMap.forEach { (prize, count) ->
            totalPrizeMoney += prize.money * count
        }

        return totalPrizeMoney
    }
}
