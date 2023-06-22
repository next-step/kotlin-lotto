package lotto.domain

import lotto.domain.LottoErrorMessage.BUNUS_NUMBERS_MUST_NOT_DIFFERENT_FROM_WINNING_NUMBER

class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: LottoNumber
) {
    init {
        require(lotto.numbers.contains(bonusNumber).not()) { BUNUS_NUMBERS_MUST_NOT_DIFFERENT_FROM_WINNING_NUMBER }
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
