package lotto.domain

import lotto.error.ErrorMessage.*

class Lotto(val lotto: List<Int>) {

    init {
        require(lotto.size == LOTTO_NUMBER_COUNT) { LOTTO_COUNT_ERROR.message }
    }

    fun getMatchLottoCount(jackpotNumbers: Lotto): Int {
        return lotto.count { jackpotNumbers.lotto.contains(it) }
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
