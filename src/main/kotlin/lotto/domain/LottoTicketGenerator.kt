package lotto.domain

object LottoTicketGenerator {

    fun create(): LottoTicket {
        val numbers = NUMBERS_RANGE
            .shuffled()
            .take(NUMBERS_COUNT)
            .sorted()
        return LottoTicket(numbers)
    }

    fun create(numbers: List<Int>): LottoTicket {
        checkCount(numbers)
        checkUniqueNumbers(numbers)
        checkNumbersRange(numbers)
        return LottoTicket(numbers.sorted())
    }

    private fun checkCount(numbers: List<Int>) {
        require(numbers.count() == NUMBERS_COUNT) { "로또 번호 개수는 ${NUMBERS_COUNT}여야 합니다" }
    }

    private fun checkUniqueNumbers(numbers: List<Int>) {
        require(numbers.count() == numbers.distinct().count()) { "로또 번호는 각기 다른 숫자여야 합니다" }
    }

    private fun checkNumbersRange(numbers: List<Int>) {
        require(numbers.min() >= NUMBERS_RANGE.first) { "로또 번호는 최소 수가 ${NUMBERS_RANGE.first} 이상이여야 합니다" }
        require(numbers.max() <= NUMBERS_RANGE.last) { "로또 번호는 최대 수가 ${NUMBERS_RANGE.last} 이하여야 합니다" }
    }

    private val NUMBERS_RANGE: IntRange = 1..45
    private const val NUMBERS_COUNT: Int = 6
}
