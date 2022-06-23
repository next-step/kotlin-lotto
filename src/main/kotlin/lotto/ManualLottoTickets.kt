package lotto

data class ManualLottoTickets(
    val lottoTicket: List<LottoTicket>
) {
    val count = lottoTicket.count()
}
