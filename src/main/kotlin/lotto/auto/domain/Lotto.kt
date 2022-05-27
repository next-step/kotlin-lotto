package lotto.auto.domain

import lotto.auto.port.NumberGenerator
import lotto.auto.vo.LottoScore

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.distinct().count() == NUMBER_COUNT)
        require(numbers.all(::isValidNumber))
    }

    fun match(other: Lotto): LottoScore = LottoScore.matchCountOf(countingMatchNumber(other))

    private fun countingMatchNumber(other: Lotto): Int = numbers.count(other.numbers::contains)

    private fun isValidNumber(number: Int) = number in 1..45

    companion object {

        const val NUMBER_COUNT = 6

        fun createRandomNumbers(numberGenerator: NumberGenerator): Lotto {
            val numbers = mutableListOf<Int>()
            while (numbers.size != NUMBER_COUNT) {
                val newNumber = numberGenerator.getNumber()
                if (numbers.contains(newNumber)) continue
                numbers.add(newNumber)
            }
            return Lotto(numbers)
        }
    }
}
