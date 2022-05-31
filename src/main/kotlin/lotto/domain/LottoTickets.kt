package lotto.domain

data class LottoTickets(private val tickets: List<LottoTicket>) : List<LottoTicket> by tickets {

    val countOfManualTicket: Int = tickets.filterIsInstance<LottoTicket.ManualLottoTicket>().size
    val countOfAutoTicket: Int = tickets.filterIsInstance<LottoTicket.AutoLottoTicket>().size

    fun getLottoStatistics(lastNumbers: LottoLastNumbers): LottoStatistics =
        LottoStatistics(
            this
                .groupingBy { it.getMatch(lastNumbers) }
                .eachCount()
        )
}
