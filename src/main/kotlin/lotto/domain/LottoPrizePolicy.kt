package lotto.domain

class LottoPrizePolicy(
    val winningNumberMatchCount: Int,
    val wonPrize: Money,
    private val includeBonusNumber: Boolean? = null,
) {

    fun includeBonusNumber(): Boolean {
        return includeBonusNumber == true
    }

    fun isWon(lottoTicket: LottoTicket, winningLottoNumbers: WinningLottoNumbers): Boolean {
        if (includeBonusNumber != null &&
            winningLottoNumbers.hasBonusNumber(lottoTicket.lottoTicketNumbers) == includeBonusNumber &&
            winningLottoNumbers.getMatchedCountOfWinning(lottoTicket.lottoTicketNumbers) == winningNumberMatchCount
        ) {
            return true
        }
        if (includeBonusNumber == null &&
            winningLottoNumbers.getMatchedCountOfWinning(lottoTicket.lottoTicketNumbers) == winningNumberMatchCount
        ) {
            return true
        }
        return false
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
