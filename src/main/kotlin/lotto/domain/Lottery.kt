package lotto.domain

import lotto.infra.port.NumberGenerator
import lotto.vo.LottoScore

@JvmInline
value class Lottery(private val numbers: List<Int>) {

    init {
        require(numbers.distinct().count() == LOTTO_NUMBER_LENGTH)
        require(numbers.all(::isValidNumber))
    }

    override fun toString(): String = numbers.toString()

    fun match(other: Lottery): LottoScore = LottoScore.of(countingMatchNumber(other))

    private fun countingMatchNumber(other: Lottery): Int = numbers.count(other.numbers::contains)

    private fun isValidNumber(number: Int) = number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER

    companion object {

        const val PRICE = 1_000
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        const val LOTTO_NUMBER_LENGTH = 6

        fun createRandomNumbers(numberGenerator: NumberGenerator<List<Int>>): Lottery {
            return Lottery(numberGenerator.generate())
        }
    }
}
