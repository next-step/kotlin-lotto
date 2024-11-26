package lotto.core

import lotto.core.constant.LottoConstants

data class Lotto(val numbers: List<Int>) {
    var winningRank: WinningRank = WinningRank.RANK0
        private set

    constructor() : this(generateNumbers())

    fun checkWinningStates(winningNumbers: WinningNumbers) {
        winningRank = WinningRank.getWinningAmount(countCommonElements(numbers, winningNumbers.winningNumbers))
    }

    private fun countCommonElements(
        list1: List<Int>,
        list2: List<Int>,
    ): Int {
        return list1.filter { it in list2 }.size
    }

    companion object {
        fun generateNumbers(): List<Int> =
            (LottoConstants.LOTTO_NUMBER_MIN..LottoConstants.LOTTO_NUMBER_MAX).shuffled().take(
                LottoConstants.LOTTO_NUMBER_COUNT,
            ).sorted()
    }
}
