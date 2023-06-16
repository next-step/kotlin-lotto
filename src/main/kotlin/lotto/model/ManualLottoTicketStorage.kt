package lotto.model

class ManualLottoTicketStorage(private val lottoGroup: Collection<Lotto>) : LottoTicketStorage {

    override fun hasCountLessThan(count: Int): Boolean {
        return lottoGroup.size < count
    }

    override fun lottoTicketsBy(count: Int): Collection<LottoTicket> {
        if (hasCountLessThan(count)) {
            throw IllegalArgumentException(
                "lottoGroup has less than count. ticketStorage($this), count(`$count`)"
            )
        }
        return lottoGroup.take(count)
            .map { LottoTicket(it, TicketType.MANUAL) }
    }
}
