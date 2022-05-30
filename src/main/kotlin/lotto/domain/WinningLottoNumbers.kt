package lotto.domain

class WinningLottoNumbers private constructor(
    val winningLottoNumbers: LottoTicketNumbers,
    val bonusLottoNumber: LottoTicketNumber
) {
    init {
        require(winningLottoNumbers.notHasLottoNumber(bonusLottoNumber)) { "보너스 번호(${bonusLottoNumber.value})는 당첨번호 와 중복 될 수 없습니다" }
    }

    fun getMatchedCountOfWinning(lottoTicketNumbers: LottoTicketNumbers): Int {
        return winningLottoNumbers.findMatchedCount(lottoTicketNumbers)
    }

    fun hasBonusNumber(lottoTicketNumbers: LottoTicketNumbers): Boolean {
        return lottoTicketNumbers.hasLottoNumber(bonusLottoNumber)
    }

    companion object {
        fun ofInt(winningLottoNumbers: List<Int>, bonusLottoNumber: Int): WinningLottoNumbers {
            return WinningLottoNumbers(
                LottoTicketNumbers.ofInts(winningLottoNumbers),
                LottoTicketNumber(bonusLottoNumber)
            )
        }

        fun ofString(winningLottoNumbers: String, delimiters: String, bonusLottoNumber: String): WinningLottoNumbers {
            return WinningLottoNumbers(
                LottoTicketNumbers.ofString(winningLottoNumbers, delimiters),
                LottoTicketNumber.ofString(bonusLottoNumber)
            )
        }
    }
}
