package lotto.domain

object LottoTicketGenerator {

    fun create(): LottoTicket {
        val numbers = NUMBERS_RANGE
            .shuffled()
            .take(NUMBERS_COUNT)
            .sorted()
        return LottoTicket(numbers)
    }

    private val NUMBERS_RANGE: IntRange = 1..45
    private const val NUMBERS_COUNT: Int = 6
}
