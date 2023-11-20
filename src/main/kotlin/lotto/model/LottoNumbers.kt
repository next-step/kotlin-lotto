package lotto.model

import lotto.utils.shuffleAndTake

class LottoNumbers private constructor(val numbers: List<Int>) {
    fun match(target: LottoNumbers): Int {
        val sourceLottoNumbers = numbers
        val targetLottoNumbers = target.numbers.toSet()

        return sourceLottoNumbers
            .intersect(targetLottoNumbers)
            .size
    }

    fun contain(number: Int): Boolean {
        return numbers.contains(number)
    }

    companion object {
        private val LOTTO_NUMBER_POOL = (1..45).toList()
        const val LOTTO_NUMBERS_LENGTH = 6

        fun create(numbers: List<Int>): LottoNumbers {
            val lottoNumbers = numbers
                .run { validateLottoNumbersLength(this) }
                .map { validateLottoNumber(it) }

            return LottoNumbers(lottoNumbers)
        }

        private fun validateLottoNumbersLength(numbers: List<Int>): List<Int> {
            require(numbers.toSet().size == LOTTO_NUMBERS_LENGTH) {
                "로또 번호는 6개이어야하며 중복된 숫자가 존재해선 안됩니다."
            }

            return numbers
        }

        private fun validateLottoNumber(lottoNumber: Int): Int {
            require(LOTTO_NUMBER_POOL.contains(lottoNumber)) {
                "로또 번호는 1 이상 45 이하의 자연수입니다."
            }

            return lottoNumber
        }

        fun generate(lottoNumbersCount: Int): List<LottoNumbers> {
            return (0 until lottoNumbersCount)
                .map { generate() }
        }

        private fun generate(): LottoNumbers {
            val numbers = LOTTO_NUMBER_POOL.shuffleAndTake(LOTTO_NUMBERS_LENGTH, sort = true)

            return LottoNumbers(numbers)
        }
    }
}
