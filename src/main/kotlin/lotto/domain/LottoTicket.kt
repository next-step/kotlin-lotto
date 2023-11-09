package lotto.domain

class LottoTicket(private val numbers: List<Int>) {

    init {
        validateNumbers(numbers)
    }

    fun getMatchingNumbersCount(winningNumbers: Set<Int>): Int {
        return numbers.intersect(winningNumbers).size
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun containsBonusBall(bonusBall: Int): Boolean {
        return numbers.contains(bonusBall)
    }

    private fun validateNumbers(numbers: List<Int>) {
        require(numbers.size == LottoConstants.NUMBERS_PER_TICKET) { "번호는 정확히 ${LottoConstants.NUMBERS_PER_TICKET}개 이어야 합니다." }
        require(numbers.distinct().size == numbers.size) { "번호는 모두 달라야 합니다." }
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
