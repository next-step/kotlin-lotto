package lotto.domain

class WinningLottoNumbers(
    val winningLottoNumbers: LottoTicketNumbers,
    val bonusLottoNumber: LottoTicketNumber
) {
    init {
        require(winningLottoNumbers.hasNotLottoNumber(bonusLottoNumber)) { "보너스 번호(${bonusLottoNumber.value})는 당첨번호 와 중복 될 수 없습니다" }
    }

    fun getMatchedCountOfWinning(lottoTicketNumbers: LottoTicketNumbers): Int {
        return winningLottoNumbers.findMatchedCount(lottoTicketNumbers)
    }

    fun hasBonusNumber(lottoTicketNumbers: LottoTicketNumbers): Boolean {
        return lottoTicketNumbers.hasLottoNumber(bonusLottoNumber)
    }

    companion object {
        fun ofString(winningLottoNumbers: String, winningLottoNumberDelimiter: Delimiter, bonusLottoNumber: String): WinningLottoNumbers {
            return WinningLottoNumbers(
                LottoTicketNumbers.ofInts(winningLottoNumberDelimiter.parseNumbers(winningLottoNumbers)),
                LottoTicketNumber.ofString(bonusLottoNumber)
            )
        }
    }
}
