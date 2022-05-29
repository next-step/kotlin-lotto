package lotto.domain

class WinningLottoNumbers private constructor(
    val winningLottoNumbers: LottoTicketNumbers,
    val bonusLottoNumber: LottoTicketNumber
) {
    init {
        // TODO LottoTicketNumbers 로 이동시키기
        require(
            !winningLottoNumbers.value.map { it.value }
                .contains(bonusLottoNumber.value)
        ) { "보너스 번호(${bonusLottoNumber.value})는 당첨번호 와 중복 될 수 없습니다" }
    }

    fun getMatchedCountOfWinning(lottoTicketNumbers: LottoTicketNumbers): Int {
        return winningLottoNumbers.findMatchedCount(lottoTicketNumbers)
    }

    fun hasBonusNumber(lottoTicketNumbers: LottoTicketNumbers): Boolean {
        // TODO LottoTicketNumbers 로 이동시키기
        return lottoTicketNumbers.value.map { it.value }.contains(bonusLottoNumber.value)
    }

    companion object {
        fun ofInt(winningLottoNumbers: List<Int>, bonusLottoNumber: Int): WinningLottoNumbers {
            return WinningLottoNumbers(
                LottoTicketNumbers.ofInts(winningLottoNumbers),
                LottoTicketNumber(bonusLottoNumber)
            )
        }
    }
}
