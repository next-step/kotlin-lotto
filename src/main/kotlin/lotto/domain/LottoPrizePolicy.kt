package lotto.domain

class LottoPrizePolicy(
    val wonMatchedCount: Int,
    val wonPrize: Money
) {

    fun isWon(lottoTicket: LottoTicket, winningLottoNumbers: LottoTicketNumbers): Boolean {
        return won(lottoTicket, winningLottoNumbers) != null
    }

    fun won(lottoTicket: LottoTicket, winningLottoNumbers: LottoTicketNumbers): Money? {
        if (lottoTicket.getMatchedCount(winningLottoNumbers) == wonMatchedCount) return wonPrize
        return null
    }
}
