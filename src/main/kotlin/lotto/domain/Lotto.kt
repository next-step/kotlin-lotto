package lotto.domain

import lotto.infra.port.NumberGenerator
import lotto.vo.LottoScore

@JvmInline
value class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.distinct().count() == LOTTO_NUMBER_LENGTH)
        require(numbers.all(::isValidNumber))
    }

    override fun toString(): String = numbers.toString()

    fun match(other: Lotto): LottoScore = LottoScore.matchCountOf(countingMatchNumber(other))

    private fun countingMatchNumber(other: Lotto): Int = numbers.count(other.numbers::contains)

    private fun isValidNumber(number: Int) = number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER

    companion object {

        const val PRICE = 1_000

        private const val LOTTO_NUMBER_LENGTH = 6
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45

        fun createRandomNumbers(numberGenerator: NumberGenerator): Lotto {
            val numbers = mutableListOf<Int>()
            while (numbers.size != LOTTO_NUMBER_LENGTH) {
                val newNumber = numberGenerator.getNumber()
                if (numbers.contains(newNumber)) continue
                numbers.add(newNumber)
            }
            return Lotto(numbers)
        }
    }
}
