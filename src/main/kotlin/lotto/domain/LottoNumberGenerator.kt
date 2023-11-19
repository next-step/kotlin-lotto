package lotto.domain

import lotto.error.InvalidLottoNumberException

object LottoNumberGenerator {

    fun createFrom(): LottoNumber {
        val numbers = NUMBERS_RANGE
            .shuffled()
            .take(NUMBERS_COUNT)
            .sorted()
        return LottoNumber(numbers)
    }

    fun createFrom(numbers: List<Int>): LottoNumber {
        checkCount(numbers)
        checkUniqueNumbers(numbers)
        checkNumbersRange(numbers)
        return LottoNumber(numbers.sorted())
    }

    fun checkNumber(number: Int): Int {
        checkNotBelowMinimum(number)
        checkNotOverMaximum(number)
        return number
    }

    private fun checkCount(numbers: List<Int>) {
        require(numbers.count() == NUMBERS_COUNT) { throw InvalidLottoNumberException("로또 번호 개수는 ${NUMBERS_COUNT}여야 합니다") }
    }

    private fun checkUniqueNumbers(numbers: List<Int>) {
        require(numbers.count() == numbers.distinct().count()) { throw InvalidLottoNumberException("로또 번호는 각기 다른 숫자여야 합니다") }
    }

    private fun checkNumbersRange(numbers: List<Int>) {
        checkNotBelowMinimum(numbers.min())
        checkNotOverMaximum(numbers.max())
    }

    private fun checkNotBelowMinimum(number: Int) {
        require(number >= NUMBERS_RANGE.first) { throw InvalidLottoNumberException("로또 번호는 최소 수가 ${NUMBERS_RANGE.first} 이상이여야 합니다") }
    }

    private fun checkNotOverMaximum(number: Int) {
        require(number <= NUMBERS_RANGE.last) { throw InvalidLottoNumberException("로또 번호는 최대 수가 ${NUMBERS_RANGE.last} 이하여야 합니다") }
    }

    private val NUMBERS_RANGE: IntRange = 1..45
    private const val NUMBERS_COUNT: Int = 6
}
