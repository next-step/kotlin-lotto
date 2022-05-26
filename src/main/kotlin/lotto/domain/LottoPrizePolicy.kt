package lotto.domain

class LottoPrizePolicy(
    private val wonMatchedCount: Int,
    private val winningLottoNumber: List<LottoTicketNumber>,
    private val wonPrize: Money
) : PrizePolicy<LottoTicket, Money> {
    override fun won(lottoTicket: LottoTicket): Money? {
        val matchedNumberCount =
            lottoTicket.lottoTicketNumbers.count { lottoTicketNumber -> winningLottoNumber.contains(lottoTicketNumber) }
        if (matchedNumberCount == wonMatchedCount) return wonPrize
        return null
    }
}
