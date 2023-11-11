package lotto.domain

import lotto.util.NumberGenerator

class Lotto private constructor(
    private val numbers: List<LottoNumber>,
) {

    val sortedNumbers: List<LottoNumber> =
        numbers.sortedBy { it.value }

    init {
        validateCount()
        validateDuplication()
    }

    fun calculateMatchCount(other: Lotto, bonusBall: LottoNumber): Int {
        val matchCount = numbers.intersect(other.numbers.toSet()).size
        if (LottoRank.isSecondOrThirdRank(matchCount).not() && hasBonusBall(bonusBall)) {
            return matchCount.inc()
        }
        return matchCount
    }

    fun hasBonusBall(number: LottoNumber): Boolean =
        numbers.contains(number)

    private fun validateCount() {
        require(numbers.size == LOTTO_NUMBER_COUNT) {
            "로또 번호는 ${LOTTO_NUMBER_COUNT}개여야 합니다."
        }
    }

    private fun validateDuplication() {
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) {
            "로또 번호는 중복되지 않아야 합니다."
        }
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_PRICE = 1000

        fun from(lottoNumberGenerator: NumberGenerator): Lotto {
            val lottoNumbers = lottoNumberGenerator.generate(
                count = LOTTO_NUMBER_COUNT
            )
            return from(lottoNumbers)
        }

        fun from(numbers: List<Int>): Lotto {
            val lottoNumbers = numbers.map { LottoNumber.from(it) }
            return Lotto(lottoNumbers)
        }
    }
}
