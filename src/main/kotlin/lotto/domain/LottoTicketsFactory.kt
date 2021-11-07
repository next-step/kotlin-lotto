package lotto.domain

object LottoTicketsFactory {

    private const val NUMBER_DELIMITER = ","

    @Suppress("NAME_SHADOWING")
    fun create(count: LottoTicketCount): LottoTickets {
        var count = count
        val tickets = mutableListOf<LottoNumbers>()
        while (count.isTicketRemain()) {
            val newTicket = LottoGenerator.randomTicket()
            tickets.add(newTicket)
            count = count.useTicket()
        }
        return LottoTickets(tickets)
    }

    fun convertToTickets(inputs: List<String>): LottoTickets {
        return LottoTickets(inputs.map(::toTicket))
    }

    private fun toTicket(value: String): LottoNumbers {
        return value.split(NUMBER_DELIMITER)
            .map { LottoNumber.valueOf(it.trim()) }
            .let(::LottoNumbers)
    }
}
