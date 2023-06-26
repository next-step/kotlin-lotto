package lotto.domain

import lotto.domain.LottoErrorMessage.BONUS_NUMBERS_MUST_NOT_DIFFERENT_FROM_WINNING_NUMBER

class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: LottoNumber
) {
    init {
        require(lotto.numbers.contains(bonusNumber).not()) { BONUS_NUMBERS_MUST_NOT_DIFFERENT_FROM_WINNING_NUMBER }
    }

    fun statistics(lottos: Lottos, budget: Int): LottosStatisticsVO {
        val winningMap = lottos.winningMap(this)
        val totalPrizeMoney = winningMap.totalPrizeMoney()
        val rateOfReturn = totalPrizeMoney.toDouble() / budget.toDouble()

        return LottosStatisticsVO(winningMap, totalPrizeMoney, rateOfReturn)
    }
}
