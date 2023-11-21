package lotto.model

import lotto.utils.shuffleAndTake

class LottoNumbers private constructor(val numbers: List<LottoNumber>) {
    fun match(target: LottoNumbers): Int {
        val sourceLottoNumbers = numbers.map { it.number }
        val targetLottoNumbers = target.numbers.map { it.number }.toSet()

        return sourceLottoNumbers
            .intersect(targetLottoNumbers)
            .size
    }

    fun contain(number: LottoNumber): Boolean {
        return numbers.find { it.number == number.number } != null
    }

    companion object {
        const val LOTTO_NUMBERS_LENGTH = 6

        fun create(numbers: List<Int>): LottoNumbers {
            val lottoNumbers = numbers
                .run { validateLottoNumbersLength(this) }
                .map { LottoNumber.from(it) }

            return LottoNumbers(lottoNumbers)
        }

        private fun validateLottoNumbersLength(numbers: List<Int>): List<Int> {
            require(numbers.toSet().size == LOTTO_NUMBERS_LENGTH) {
                "로또 번호는 6개이어야하며 중복된 숫자가 존재해선 안됩니다."
            }

            return numbers
        }

        fun generate(lottoNumbersCount: Int): List<LottoNumbers> {
            return (0 until lottoNumbersCount)
                .map { generate() }
        }

        private fun generate(): LottoNumbers {
            val numbers: List<LottoNumber> = LottoNumber.LOTTO_NUMBER_RANGE
                .shuffleAndTake(LOTTO_NUMBERS_LENGTH, sort = true)
                .map { LottoNumber.from(it) }

            return LottoNumbers(numbers)
        }
    }
}
