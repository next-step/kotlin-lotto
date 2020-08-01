package lotto

import java.lang.IndexOutOfBoundsException

const val COUNT_OF_NUMBERS = 6
private const val MAX_NUMBER = 45
private const val MIN_NUMBER = 1
private val PRIZE_AMOUNT = listOf(0, 0, 0, 5000, 50000, 1500000, 2000000000)

object Lotto {

    fun getNumbers(): List<Int> {
        return (MIN_NUMBER..MAX_NUMBER).shuffled().subList(0, COUNT_OF_NUMBERS).sorted()
    }

    fun getMatchCount(lottoNumbers: List<Int>, prizeNumbers: List<Int>): Int {
        var count: Int = 0
        lottoNumbers.forEach { if (prizeNumbers.contains(it)) count++ }
        return count
    }

    fun getPrizeAmount(matchCount: Int): Int {
        try {
            return PRIZE_AMOUNT[matchCount]
        } catch (e: IndexOutOfBoundsException) {
            throw IndexOutOfBoundsException("숫자를 확인해 주세요.")
        }
    }
}
