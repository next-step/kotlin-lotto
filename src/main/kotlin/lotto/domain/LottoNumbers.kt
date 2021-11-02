package lotto.domain

import lotto.domain.LottoOperator.LOTTO_FIRST_NUMBER
import lotto.domain.LottoOperator.LOTTO_LAST_NUMBER
import lotto.domain.LottoOperator.LOTTO_SIZE
import lotto.exception.InvalidLottoNumberException

@JvmInline
value class LottoNumbers(
    val value: List<LottoNumber>,
) {
    init {
        if (value.isEmpty() || value.distinct().size != LOTTO_SIZE) {
            throw InvalidLottoNumberException()
        }
    }

    fun containsWinningNumbers(winningNumber: Int): Boolean {
        return value.contains(LottoNumber(winningNumber))
    }

    fun containsBonusNumber(bonusNumber: Int): Boolean {
        return value.contains(LottoNumber(bonusNumber))
    }

    companion object {
        val LOTTO_NUMBERS: List<LottoNumber> = (LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER)
            .map { LottoNumber(it) }
            .toList()
    }
}
