package lotto.domain

object LottoTicketMachine {

    fun generate(size: Int = 1) = List(size) { LottoTicket(generateNumbers()) }

    private fun generateNumbers(): Set<Int> {
        return LottoTicket.RANGE_OF_LOTTO_NUMBER
            .shuffled()
            .take(LottoTicket.SIZE_OF_LOTTO_NUMBER)
            .sorted()
            .toSet()
    }
}
