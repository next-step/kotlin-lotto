package lotto.domain

class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: LottoNumber
) {
    init {
        require(lotto.numbers.contains(bonusNumber).not()) { "보너스 번호는 당첨 번호와 중복되지 않아야 합니다." }
    }

    fun calculateStatistics(lottos: Lottos, budget: Int): LottosStatisticsVO {
        val prizeMap = lottos.generateWinningMap(this)
        val totalPrizeMoney = calculateTotalPrizeMoney(prizeMap)
        val rateOfReturn = totalPrizeMoney.toDouble() / budget.toDouble()

        return LottosStatisticsVO(prizeMap, totalPrizeMoney, rateOfReturn)
    }

    private fun calculateTotalPrizeMoney(prizeMap: Map<LottoPrizes, Int>): Int {
        var totalPrizeMoney = 0

        prizeMap.forEach { (prize, count) ->
            totalPrizeMoney += prize.money * count
        }

        return totalPrizeMoney
    }
}
