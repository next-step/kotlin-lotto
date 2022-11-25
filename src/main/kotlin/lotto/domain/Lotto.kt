package lotto.domain

import lotto.util.ErrorCode

data class Lotto(
    val numbers: List<LottoNumber>
) {
    init {
        require(numbers.distinct().count() == LOTTO_NUMBER_COUNT) {
            ErrorCode.LOTTO_NUMBERS_COUNT_EXCEPTION.errorMessage
        }
    }

    override fun toString(): String {
        return numbers.toString()
    }

    fun getMatchCount(otherLotto: Lotto): Int =
        otherLotto.numbers.toMutableSet()
            .intersect(numbers.toMutableSet())
            .count()

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
