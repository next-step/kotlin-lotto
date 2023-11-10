package lotto.domain

class LottoTicket(private val numbers: List<Int>) {
    val readOnlyNumbers: List<Int>
        get() = numbers.toList()

    init {
        validateNumbersCount(numbers)
        validateDistinctNumbers(numbers)
        validateNumberRange(numbers)
    }

    private fun validateNumbersCount(numbers: List<Int>) {
        require(numbers.size == LottoConstants.NUMBERS_PER_TICKET) { "번호는 정확히 ${LottoConstants.NUMBERS_PER_TICKET}개 이어야 합니다." }
    }

    private fun validateDistinctNumbers(numbers: List<Int>) {
        require(numbers.distinct().size == numbers.size) { "번호는 모두 달라야 합니다." }
    }

    private fun validateNumberRange(numbers: List<Int>) {
        require(numbers.all { it in LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END }) { "번호는 ${LottoConstants.NUMBER_RANGE_START}에서 ${LottoConstants.NUMBER_RANGE_END} 범위 내에 있어야 합니다." }
    }

    companion object {
        fun generate(): LottoTicket {
            val numbers = (LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END)
                .shuffled()
                .take(LottoConstants.NUMBERS_PER_TICKET)
                .sorted()
            return LottoTicket(numbers)
        }
    }
}
