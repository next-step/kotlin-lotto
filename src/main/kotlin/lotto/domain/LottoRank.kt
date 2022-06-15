package lotto.domain

enum class LottoRank(
    val winningNumberMatchCount: Int,
    val wonPrize: Money,
    private val includeBonusNumber: Boolean? = null,
) {
    ONE(6, Money(2_000_000_000)),
    TWO(5, Money(30_000_000), true),
    THREE(5, Money(1_500_000), false),
    THIRD(4, Money(50_000)),
    FOURTH(3, Money(5_000)),
    ;

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
}
