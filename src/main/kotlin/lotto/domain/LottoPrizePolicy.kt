package lotto.domain

class LottoPrizePolicy(
    private val wonMatchedCount: Int,
    private val winningLottoNumbers: LottoTicketNumbers,
    private val wonPrize: Money
) : PrizePolicy<LottoTicket, Money> {
    override fun won(lottoTicket: LottoTicket): Money? {
        if (lottoTicket.getMatchedCount(winningLottoNumbers) == wonMatchedCount) return wonPrize
        return null
    }
}
