package lotto.domain

data class LottoTickets(private val tickets: List<LottoTicket>) : List<LottoTicket> by tickets {

    val countOfManualTicket: Int = tickets.filter { it.isManual }.size
    val countOfAutoTicket: Int = tickets.filterNot { it.isManual }.size

    init {
        require(isNotEmpty())
    }

    fun getLottoStatistics(lastNumbers: LottoLastNumbers): LottoStatistics =
        LottoStatistics(
            this
                .map { it.getMatch(lastNumbers) }
                .groupBy { it }
                .map { it.key to it.value.size }
                .toMap()
        )
}
