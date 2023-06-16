package lotto.domain

class LottoStatistics(
    private val lottos: List<Lotto>,
    private val budget: Int,
    private val winningLotto: Lotto
) {
    private val countsMap = mutableMapOf<Int, Int>()

    var totalPrizes = 0
        private set

    var rateOfReturn = 0.0
        private set

    init {
        calculateTotalPrizes()
        calculateRateOfReturn()
    }

    fun getEqualCount(equalCount: Int): Int {
        return countsMap.getOrDefault(equalCount, 0)
    }

    private fun calculateTotalPrizes() {
        lottos.forEach {
            val equalCount = winningLotto.checkEqualCount(it)
            countsMap[equalCount] = countsMap.getOrDefault(equalCount, 0) + 1

            val prize = LottoPrizes.getMoney(equalCount)
            totalPrizes += prize
        }
    }

    private fun calculateRateOfReturn() {
        rateOfReturn = totalPrizes.toDouble() / budget.toDouble()
    }
}
