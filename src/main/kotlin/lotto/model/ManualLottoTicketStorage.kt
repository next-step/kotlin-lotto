package lotto.model

class ManualLottoTicketStorage(private val lottoGroup: Collection<Lotto>) : LottoTicketStorage {

    override infix fun hasCountEqualOrGreaterThan(count: Int): Boolean {
        return count <= lottoGroup.size
    }

    override infix fun lottoTicketsBy(count: Int): Collection<LottoTicket> {
        require(hasCountEqualOrGreaterThan(count)) {
            "lottoGroup has less than count. ticketStorage($this), count(`$count`)"
        }
        return lottoGroup.take(count)
            .map { LottoTicket(it, TicketType.MANUAL) }
    }
}
