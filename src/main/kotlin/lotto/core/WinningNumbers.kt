package lotto.core

import lotto.core.constant.LottoConstants

data class WinningNumbers(val winningNumbers: List<Int>) {
    init {
        if (winningNumbers.size != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw IllegalArgumentException("당첨 번호의 숫자가 잘못되었습니다.")
        }
    }

    fun countCommonNumbers(lotto: Lotto): Int {
        return winningNumbers.filter { it in lotto.numbers }.size
    }
}
