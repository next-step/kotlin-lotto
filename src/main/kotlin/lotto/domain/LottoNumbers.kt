package lotto.domain

import lotto.exception.DuplicateLottoNumberException
import lotto.exception.InvalidLottoNumberSizeException

class LottoNumbers private constructor(val numbers: List<LottoNumber>) {

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
        return LottoNumber.of(number) in numbers
    }

    operator fun contains(number: LottoNumber): Boolean {
        return number in numbers
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6

        fun from(numbers: List<Int>): LottoNumbers {
            return LottoNumbers(numbers.take(LOTTO_NUMBER_SIZE).map { LottoNumber.of(it) })
        }

        fun of(vararg numbers: Int): LottoNumbers {
            return LottoNumbers(numbers.toList().map { LottoNumber.of(it) })
        }

        fun of(lottoNumbers: List<LottoNumber>): LottoNumbers {
            return LottoNumbers(lottoNumbers)
        }
    }
}
