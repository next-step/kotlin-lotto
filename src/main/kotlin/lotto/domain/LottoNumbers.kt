package lotto.domain

import lotto.exception.DuplicateLottoNumberException
import lotto.exception.InvalidLottoNumberSizeException

class LottoNumbers(vararg numbers: Int) {

    val numbers: List<LottoNumber> = numbers.toList().map { LottoNumber(it) }

    init {
        if (numbers.size != LOTTO_NUMBER_SIZE) throw InvalidLottoNumberSizeException()
        if (numbers.distinct().size != LOTTO_NUMBER_SIZE) throw DuplicateLottoNumberException()
    }

    fun matchingNumbers(numbers: LottoNumbers): List<LottoNumber> {
        return this.numbers.intersect(numbers.numbers.toSet())
            .toList()
            .sortedBy { it.number }
    }

    override fun toString(): String = numbers
        .sortedBy { it.number }
        .toString()

    operator fun contains(number: Int): Boolean {
        return LottoNumber(number) in numbers
    }

    operator fun contains(number: LottoNumber): Boolean {
        return number in numbers
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6

        fun from(numbers: List<Int>): LottoNumbers {
            return LottoNumbers(*numbers.take(LOTTO_NUMBER_SIZE).toIntArray())
        }
    }
}
