package lotto.domain

import lotto.domain.ExceptionType.LAST_WEEK_INPUT_NUMBERS_SIZE_MUST_SIX
import lotto.domain.ExceptionType.LAST_WEEK_NUMBERS_SIZE_MUST_SIX

class LastWeekNumber(numbers: List<Int>) {
    private val numbersSet = numbers.toSet()

    init {
        require(numbers.size == 6) { LAST_WEEK_INPUT_NUMBERS_SIZE_MUST_SIX }
        require(numbersSet.size == 6) { LAST_WEEK_NUMBERS_SIZE_MUST_SIX }
    }

    fun contains(number: Int) = numbersSet.contains(number)

    fun getLastWeekSetList() = numbersSet.toSet()
}
