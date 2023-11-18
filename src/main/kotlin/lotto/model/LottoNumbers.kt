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

    companion object {
        private val LOTTO_NUMBER_POOL = (1..45).toList()
        private const val LOTTO_NUMBERS_LENGTH = 6

        fun create(numbers: List<Int>): LottoNumbers {
            require(numbers.size == LOTTO_NUMBERS_LENGTH ) {
                "로또 번호는 6개 입니다."
            }

            val lottoNumbers = numbers.map { validateLottoNumber(it) }

            return LottoNumbers(lottoNumbers)
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
            val numbers = shuffleAndTake(LOTTO_NUMBER_POOL, LOTTO_NUMBERS_LENGTH, sort = true)

            return LottoNumbers(numbers)
        }
    }
}
