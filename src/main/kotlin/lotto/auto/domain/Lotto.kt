package lotto.auto.domain

import lotto.auto.vo.LottoScore

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.distinct().count() == NUMBER_COUNT)
    }

    fun match(other: Lotto): LottoScore = LottoScore.matchCountOf(countingMatchNumber(other))

    private fun countingMatchNumber(other: Lotto): Int = numbers.count(other.numbers::contains)

    companion object {

        const val NUMBER_COUNT = 6
    }
}
