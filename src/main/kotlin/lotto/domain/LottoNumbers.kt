package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_SIZE
import lotto.exception.InvalidLottoNumberException

class LottoNumbers(
    value: List<LottoNumber>,
) {
    val value = value.toList()

    init {
        if (this.value.isEmpty() || this.value.distinct().size != LOTTO_SIZE) {
            throw InvalidLottoNumberException()
        }
    }

    fun containsWinningNumbers(winningNumber: Int): Boolean {
        return value.contains(LottoNumber.valueOf(winningNumber))
    }

    fun containsBonusNumber(bonusNumber: Int): Boolean {
        return value.contains(LottoNumber.valueOf(bonusNumber))
    }
}
