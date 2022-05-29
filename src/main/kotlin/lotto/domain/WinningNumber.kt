package lotto.domain

class WinningNumber {
    fun winningNumberToLottoTicket(winningNumbers: List<Int>): LottoTicket {
        val lottoNumbers = winningNumbers.map { LottoNumber(it) }.toSet()
        return LottoTicket(lottoNumbers)
    }
}
