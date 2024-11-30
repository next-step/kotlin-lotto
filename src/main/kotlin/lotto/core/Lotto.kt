package lotto.core

import lotto.core.constant.LottoConstants

class Lotto(val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == LottoConstants.LOTTO_NUMBER_COUNT) { LottoConstants.ERROR_INVALID_NUMBER_COUNT }
    }

    fun contains(number: LottoNumber): Boolean {
        return numbers.contains(number)
    }

    fun countSameNumbers(other: Lotto): Int {
        return numbers.filter { it in other.numbers }.size
    }
}
