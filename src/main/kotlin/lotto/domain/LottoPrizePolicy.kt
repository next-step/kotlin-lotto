package lotto.domain

class LottoPrizePolicy(
    val winningNumberMatchCount: Int,
    val wonPrize: Money,
    private val includeBonusNumber: Boolean = false,
) {

    fun isWon(lottoTicket: LottoTicket, winningLottoNumbers: WinningLottoNumbers): Boolean {
        return won(lottoTicket, winningLottoNumbers) != null
    }

    fun won(lottoTicket: LottoTicket, winningLottoNumbers: WinningLottoNumbers): Money? {
        if (includeBonusNumber &&
            winningLottoNumbers.hasBonusNumber(lottoTicket.lottoTicketNumbers) &&
            winningLottoNumbers.getMatchedCountOfWinning(lottoTicket.lottoTicketNumbers) == winningNumberMatchCount
        ) {
            return wonPrize
        }
        if (!includeBonusNumber &&
            winningLottoNumbers.getMatchedCountOfWinning(lottoTicket.lottoTicketNumbers) == winningNumberMatchCount
        ) {
            return wonPrize
        }
        return null
    }
}
