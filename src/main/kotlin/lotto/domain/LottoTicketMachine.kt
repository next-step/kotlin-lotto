package lotto.domain

object LottoTicketMachine {

    private const val MIN_RANGE_OF_NUMBER = 1
    private const val MAX_RANGE_OF_NUMBER = 45

    private val RANGE_OF_LOTTO_NUMBER = MIN_RANGE_OF_NUMBER..MAX_RANGE_OF_NUMBER

    fun generate(size: Int = 1) = List(size) { LottoTicket(generateNumbers()) }

    private fun generateNumbers(): Set<Int> {
        return RANGE_OF_LOTTO_NUMBER
            .shuffled()
            .take(LottoTicket.SIZE_OF_LOTTO_NUMBER)
            .sorted()
            .toSet()
    }
}
