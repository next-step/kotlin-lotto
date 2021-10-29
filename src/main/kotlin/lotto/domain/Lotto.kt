package lotto.domain

import lotto.exception.IllegalLottoException

data class Lotto(val numbers: List<LottoNumber>) {
    init {
        if (numbers.size != SIZE) {
            throw IllegalLottoException()
        }
    }

    fun checkMatch(winningLotto: Lotto): Match {
        return Match.valueOf(numbers.count { winningLotto.numbers.contains(it) })
    }

    companion object {
        const val SIZE = 6
        fun from(numbers: List<Int>): Lotto {
            return Lotto(numbers.map { LottoNumber(it) })
        }
    }
}
