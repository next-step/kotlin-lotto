package lotto.domain

data class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: LottoNumber
) {
    fun calculateStatistics(lottos: Lottos, budget: Int): LottosStatisticsVO {
        val prizeMap = generateWinningMap(lottos)
        val totalPrizeMoney = calculateTotalPrizeMoney(prizeMap)
        val rateOfReturn = totalPrizeMoney.toDouble() / budget.toDouble()

        return LottosStatisticsVO(prizeMap, totalPrizeMoney, rateOfReturn)
    }

    private fun generateWinningMap(lottos: Lottos): Map<LottoPrizes, Int> {
        val map = mutableMapOf<LottoPrizes, Int>()

        lottos.lottos.forEach { lotto ->
            val equalCount = lotto.checkEqualCount(this)
            val isCatchBonus = lotto.isCatchBonus(bonusNumber)
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
