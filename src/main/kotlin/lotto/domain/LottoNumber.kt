package lotto.domain

import lotto.exception.InvalidLottoNumberException

@JvmInline
value class LottoNumber(
    val value: List<Int>,
) {
    init {
        val immutableLottoNumber = value.toList()
        if (immutableLottoNumber.isEmpty() || immutableLottoNumber.distinct().size != LOTTO_SIZE) {
            throw InvalidLottoNumberException()
        }
    }

    fun containsWinningNumbers(winningNumber: Int): Boolean = value.contains(winningNumber)

    companion object {
        private const val LOTTO_SIZE = 6
    }
}
