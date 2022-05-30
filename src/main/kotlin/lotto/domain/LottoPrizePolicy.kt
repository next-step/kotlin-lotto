package lotto.domain

class LottoPrizePolicy(
    val winningNumberMatchCount: Int,
    val wonPrize: Money,
    private val includeBonusNumber: Boolean? = null,
) {
    fun isWon(lottoTicket: LottoTicket, winningLottoNumbers: WinningLottoNumbers): Boolean {
        return won(lottoTicket, winningLottoNumbers) != null
    }

    fun won(lottoTicket: LottoTicket, winningLottoNumbers: WinningLottoNumbers): Money? {
        if (includeBonusNumber != null &&
            winningLottoNumbers.hasBonusNumber(lottoTicket.lottoTicketNumbers) == includeBonusNumber &&
            winningLottoNumbers.getMatchedCountOfWinning(lottoTicket.lottoTicketNumbers) == winningNumberMatchCount
        ) {
            return wonPrize
        }
        if (includeBonusNumber == null &&
            winningLottoNumbers.getMatchedCountOfWinning(lottoTicket.lottoTicketNumbers) == winningNumberMatchCount
        ) {
            return wonPrize
        }
        return null
    }

    override fun equals(other: Any?): Boolean {
        if (other !is LottoPrizePolicy) {
            return false
        }
        if ((other.includeBonusNumber == null || this.includeBonusNumber == null) &&
            other.winningNumberMatchCount == this.winningNumberMatchCount
        ) {
            return true
        }
        if ((other.includeBonusNumber != null && this.includeBonusNumber != null) &&
            (other.includeBonusNumber == this.includeBonusNumber) &&
            (other.winningNumberMatchCount == this.winningNumberMatchCount)
        ) {
            return true
        }

        return false
    }
}
