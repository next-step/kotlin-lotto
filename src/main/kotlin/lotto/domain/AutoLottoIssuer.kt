package lotto.domain

object AutoLottoIssuer {
    fun issueAutoLottoTickets(
        autoLottoCount: Int,
        generateLottoNumbers: () -> LottoNumbers,
    ): LottoTickets {
        val autoLottoTickets = mutableListOf<LottoTicket.AutoLottoTicket>()

        repeat(autoLottoCount) { autoLottoTickets.add(LottoTicket.AutoLottoTicket { generateLottoNumbers() }) }

        return LottoTickets(autoLottoTickets)
    }
}
