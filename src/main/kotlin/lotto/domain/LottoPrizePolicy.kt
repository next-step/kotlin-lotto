package lotto.domain

class LottoPrizePolicy(
    val wonMatchedCount: Int,
    val wonPrize: Money
) {
    fun won(lottoTicket: LottoTicket, winningLottoNumbers: LottoTicketNumbers): Money? {
        if (lottoTicket.getMatchedCount(winningLottoNumbers) == wonMatchedCount) return wonPrize
        return null
    }
}
