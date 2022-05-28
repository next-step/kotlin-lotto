package lotto.domain

data class LottoTickets(private val tickets: List<LottoTicket>) : List<LottoTicket> by tickets {

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
