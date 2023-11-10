package lotto.domain

import lotto.util.NumberGenerator

class Lotto private constructor(
    val numbers: List<LottoNumber>,
) {

    fun calculateMatchCount(other: Lotto): Int {
        return numbers.intersect(other.numbers.toSet()).size
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_PRICE = 1000

        fun from(lottoNumberGenerator: NumberGenerator): Lotto {
            val lottoNumbers = lottoNumberGenerator.generate(
                LottoNumber.LOTTO_MIN_NUMBER,
                LottoNumber.LOTTO_MAX_NUMBER,
                LOTTO_NUMBER_COUNT
            ).map { LottoNumber(it) }
            return from(lottoNumbers)
        }

        fun from(lottoNumbers: List<LottoNumber>): Lotto {
            validate(lottoNumbers)
            val sortedNumbers = lottoNumbers.sortedBy { it.value }
            return Lotto(sortedNumbers)
        }

        private fun validate(numbers: List<LottoNumber>) {
            validateCount(numbers)
            validateDuplication(numbers)
        }

        private fun validateCount(numbers: List<LottoNumber>) {
            require(numbers.size == LOTTO_NUMBER_COUNT) {
                "로또 번호는 ${LOTTO_NUMBER_COUNT}개여야 합니다."
            }
        }

        private fun validateDuplication(numbers: List<LottoNumber>) {
            require(numbers.toSet().size == LOTTO_NUMBER_COUNT) {
                "로또 번호는 중복되지 않아야 합니다."
            }
        }
    }
}
