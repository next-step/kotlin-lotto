package lotto.domain

import lotto.exception.DuplicateLottoNumberException
import lotto.exception.InvalidLottoNumberException
import lotto.exception.InvalidLottoNumberSizeException
import java.util.SortedSet

class Lotto(numbers: List<Int>) {
    val numbers: SortedSet<Int>

    init {
        validateNumbers(numbers)
        this.numbers = numbers.toSortedSet()
    }

    fun contains(target: Lotto): Set<Int> {
        return numbers.filter {
            target.numbers.contains(it)
        }.toSortedSet()
    }

    private fun validateNumbers(numbers: List<Int>) {
        if (numbers.size != LOTTO_NUMBER_SIZE) {
            throw InvalidLottoNumberSizeException()
        }
        if (numbers.distinct().size != LOTTO_NUMBER_SIZE) {
            throw DuplicateLottoNumberException()
        }
        if (numbers.any { it !in 1..45 }) {
            throw InvalidLottoNumberException()
        }
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}
