package lotto.domain

import lotto.exception.DuplicateLottoNumberException
import lotto.exception.InvalidLottoNumberException
import lotto.exception.InvalidLottoNumberSizeException

class LottoNumbers(val numbers: List<Int>) {

    init {
        validateNumbers()
    }

    fun matchingNumbers(numbers: LottoNumbers): List<Int> {
        return this.numbers.intersect(numbers.numbers.toSet())
            .toList()
            .sorted()
    }

    override fun toString(): String = numbers.sorted().toString()

    private fun validateNumbers() {
        if (numbers.size != LOTTO_NUMBER_SIZE) {
            throw InvalidLottoNumberSizeException()
        }
        if (numbers.distinct().size != LOTTO_NUMBER_SIZE) {
            throw DuplicateLottoNumberException()
        }
        if (numbers.any { it !in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) {
            throw InvalidLottoNumberException()
        }
    }

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_NUMBER_SIZE = 6

        fun all(): IntRange {
            return (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)
        }

        fun from(numbers: List<Int>): LottoNumbers {
            return LottoNumbers(numbers.take(LOTTO_NUMBER_SIZE))
        }
    }
}
