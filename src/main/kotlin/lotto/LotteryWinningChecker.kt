package lotto

class LotteryWinningChecker(val winningTicket: LottoTicket, val bonusNumber: LottoNumber) {
    fun checkTicket(lottoTicket: LottoTicket): WinningResult {
        return WinningResult.valueOf(lottoTicket.countOfMatches(winningTicket), lottoTicket.matchesBonusBall(bonusNumber))
    }
}
