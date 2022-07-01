package lotto.domain

data class LottoTickets(
    private val lottoTickets: List<LottoTicket>
) {
    fun get() = lottoTickets.toList()

    operator fun plus(value: LottoTickets): LottoTickets =
        LottoTickets(lottoTickets + value.lottoTickets)

    fun compareNumber(winningLotto: WinningLotto): LottoResults =
        lottoTickets.asSequence()
            .mapNotNull { it.toLottoPrize(winningLotto) }
            .groupingBy { it }
            .eachCount()
            .map(::LottoResult)
            .toLottoResults()
}
