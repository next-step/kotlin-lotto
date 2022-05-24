package lotto

object LottoTicketMachine {

    private const val MIN_RANGE_OF_NUMBER = 1
    private const val MAX_RANGE_OF_NUMBER = 45

    private val RANGE_OF_LOTTO_NUMBER = MIN_RANGE_OF_NUMBER..MAX_RANGE_OF_NUMBER
    const val SIZE_OF_LOTTO_NUMBER = 6

    fun generate(): LottoTicket = LottoTicket(generateNumbers())

    private fun generateNumbers(): List<Int> {
        return RANGE_OF_LOTTO_NUMBER
            .shuffled()
            .take(SIZE_OF_LOTTO_NUMBER)
            .sorted()
    }
}
