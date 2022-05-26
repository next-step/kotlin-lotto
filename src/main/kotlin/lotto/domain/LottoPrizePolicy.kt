package lotto.domain

class LottoPrizePolicy(
    val wonMatchedCount: Int,
    private val winningLottoNumbers: LottoTicketNumbers,
    val wonPrize: Money
) : PrizePolicy<LottoTicket, Money> {
    override fun won(lottoTicket: LottoTicket): Money? {
        if (lottoTicket.getMatchedCount(winningLottoNumbers) == wonMatchedCount) return wonPrize
        return null
    }
}
