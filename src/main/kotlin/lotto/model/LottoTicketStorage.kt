package lotto.model

interface LottoTicketStorage {

    infix fun hasCountLessThan(count: Int): Boolean

    infix fun lottoTicketsBy(count: Int): Collection<LottoTicket>
}
