package lotto.domain

data class LottoUnusedTickets(
    private val tickets: List<LottoUnusedTicket>
) {
    /**
     * @return 요청한 개수만큼 분리해서 돌려줌
     */
    fun divide(count: Int): Pair<LottoUnusedTickets, LottoUnusedTickets> {
        if (count > tickets.size) throw IllegalArgumentException("가지고 있는 티켓 수보다 많은 수를 분할 할 수 없습니다.")

        return LottoUnusedTickets(tickets.take(count)) to LottoUnusedTickets(tickets.takeLast(tickets.size - count))
    }

    fun toAuto(): LottoUsedTickets {
        val autoTickets = tickets.map {
            ticket ->
            ticket.toAuto()
        }
        return LottoUsedTickets(autoTickets)
    }

    fun toManual(inputs: List<String>): LottoUsedTickets {
        if (inputs.size != tickets.size) throw IllegalArgumentException("티켓 수와 수동 입력한 로또 개수가 다릅니다.")

        val manualTickets = inputs.zip(tickets) { input, ticket ->
            ticket.toManual(input)
        }
        return LottoUsedTickets(manualTickets)
    }

    fun getTicketCount() = tickets.size

    companion object {
        fun from(count: Int): LottoUnusedTickets {
            return LottoUnusedTickets(
                (1..count).map { LottoUnusedTicket() }
            )
        }
    }
}
