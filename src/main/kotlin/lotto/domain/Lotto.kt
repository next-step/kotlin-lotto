package lotto.domain

import lotto.util.ErrorCode

data class Lotto(
    val numbers: Set<LottoNumber>
) {
    init {
        require(numbers.count() == LOTTO_NUMBER_COUNT) {
            ErrorCode.LOTTO_NUMBERS_COUNT_EXCEPTION.errorMessage
        }
    }

    override fun toString(): String {
        return numbers.toString()
    }

    fun getMatchCount(otherLotto: Lotto): Int =
        otherLotto.numbers
            .intersect(numbers)
            .count()

    fun containLottoNumber(lottoNumber: LottoNumber): Boolean =
        numbers.contains(lottoNumber)

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
