package lotto.domain

import lotto.exception.DuplicateLottoNumberException
import lotto.exception.InvalidLottoNumberException

class Lotto(val numbers: List<Int>) {
    init {
        validateNumbers()
    }

    private fun validateNumbers() {
        if (numbers.size != LOTTO_NUMBER_SIZE) {
            throw InvalidLottoNumberException()
        }
        if (numbers.distinct().size != LOTTO_NUMBER_SIZE) {
            throw DuplicateLottoNumberException()
        }
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}
