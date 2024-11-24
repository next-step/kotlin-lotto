package lotto

class LotteryWinningChecker(val winningTicket: LottoTicket) {
    fun checkTicket(lottoTicket: LottoTicket): WinningResult {
        return WinningResult.valueOf(winningTicket.countOfMatches(lottoTicket))
    }
}
