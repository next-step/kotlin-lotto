package lotto.model

interface LottoTicketStorage {

    infix fun hasCountEqualOrGreaterThan(count: Int): Boolean

    infix fun lottoTicketsBy(count: Int): Collection<LottoTicket>
}
