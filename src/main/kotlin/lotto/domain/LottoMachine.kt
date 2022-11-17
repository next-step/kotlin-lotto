package lotto.domain

class LottoMachine {
    private fun generateNumbers(): Set<Int> {
        return (1..45).shuffled()
            .subList(0, 6).toSet()
    }

    fun purchase(count: Int): LottoTicketBulk {
        return LottoTicketBulk((1..count).map { LottoTicket.of(generateNumbers()) })
    }
}
