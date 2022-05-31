package lotto.model

import lotto.model.LottoNumber.Companion.LOTTO_NUMBERS

class Lotto private constructor(
    private val lotto: List<LottoNumber>
) {

    fun findMatchedNumberCount(other: Lotto) = other.lotto.count { lotto.contains(it) }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6

        fun generateLotto(): Lotto {
            val shuffled = LOTTO_NUMBERS.shuffled()
            return Lotto(shuffled.subList(0, LOTTO_NUMBER_COUNT))
        }

        fun of(numbers: List<Int>): Lotto {
            val lottoNumbers = numbers.map { LOTTO_NUMBERS[it - 1] }
            return Lotto(lottoNumbers)
        }
    }
}
