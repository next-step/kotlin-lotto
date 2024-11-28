package lotto.core

import lotto.core.constant.LottoConstants

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == LottoConstants.LOTTO_NUMBER_COUNT) { LottoConstants.ERROR_INVALID_NUMBER_COUNT }
        require(numbers.none { checkValidNumberScope(it) }) { LottoConstants.ERROR_INVALID_NUMBER_SCOPE }
    }

    private fun checkValidNumberScope(number: Int): Boolean {
        return number < LottoConstants.LOTTO_NUMBER_MIN || LottoConstants.LOTTO_NUMBER_MAX < number
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    fun countCommonNumbers(other: Lotto): Int {
        return numbers.filter { it in other.numbers }.size
    }
}
