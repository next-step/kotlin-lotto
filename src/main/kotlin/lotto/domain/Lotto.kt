package lotto.domain

import lotto.util.NumberGenerator

class Lotto private constructor(
    val numbers: LottoNumbers,
) {

    fun calculateMatchCount(other: Lotto, bonusBall: LottoNumber): Int {
        val matchCount = numbers.intersect(other.numbers).size
        if (hasBonusBall(bonusBall)) {
            return matchCount + 1
        }
        return matchCount
    }

    fun hasBonusBall(number: LottoNumber) =
        numbers.contains(number)

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_PRICE = 1000

        fun from(lottoNumberGenerator: NumberGenerator): Lotto {
            val lottoNumbers = lottoNumberGenerator.generate(
                min = LottoNumber.LOTTO_MIN_NUMBER,
                max = LottoNumber.LOTTO_MAX_NUMBER,
                count = LOTTO_NUMBER_COUNT
            )
            return from(lottoNumbers)
        }

        fun from(numbers: List<Int>): Lotto {
            val lottoNumbers = numbers.map { LottoNumber(it) }
            LottoNumbers(lottoNumbers).let {
                return Lotto(it)
            }
        }
    }
}
