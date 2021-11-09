package lotto.domain

import lotto.exception.InvalidLottoNumberException

class Lotto(
    value: List<LottoNumber>,
) {
    val value = value.toList()

    init {
        if (this.value.isEmpty() || this.value.distinct().size != LottoNumber.LOTTO_SIZE) {
            throw InvalidLottoNumberException()
        }
    }

    fun matchWinningNumber(winningNumber: WinningNumber): Int {
        return value.count {
            winningNumber.containsLottoNumber(it)
        }
    }

    fun matchBonusNumber(winningNumber: WinningNumber): Boolean {
        return value.any {
            winningNumber.containsBonusNumber(it)
        }
    }

    fun getLottoNumbers(): List<Int> {
        return value.map { it.value }
    }
}
