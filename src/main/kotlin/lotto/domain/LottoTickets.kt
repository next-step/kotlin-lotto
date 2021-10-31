package lotto.domain

data class LottoTickets(val count: Int) {
    val tickets: List<LottoTicket> = List(count) { LottoTicket.generateByAuto() }
}
