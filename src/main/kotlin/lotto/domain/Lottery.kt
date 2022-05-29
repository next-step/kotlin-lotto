package lotto.domain

import lotto.vo.LotteryRank

abstract class Lottery<T>(protected val numbers: List<Int>) {

    init {
        require(numbers.all(::isValidNumber))
        require(numbers.distinct().count() == LOTTO_NUMBER_LENGTH)
    }

    protected fun isValidNumber(number: Int) = number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER

    protected fun countingMatchNumber(other: Lottery<T>): Int = numbers.count(other.numbers::contains)

    abstract fun match(other: T): LotteryRank

    companion object {

        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        const val LOTTO_NUMBER_LENGTH = 6
        const val PRICE = 1_000
    }
}
