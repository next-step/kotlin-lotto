package lotto.auto.domain

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
    }
}
