package lotto.domain

class LottoStatistics(
    private val lottos: Lottos,
    budget: Int,
    winningLotto: Lotto
) {
    val totalPrizes = lottos.calculateTotalPrizes(winningLotto)

    val rateOfReturn = totalPrizes.toDouble() / budget.toDouble()

    fun getEqualCount(equalCount: Int) = lottos.getEqualCount(equalCount)
}
