package lotto

class LotteryWinningChecker(val winningTicket: LottoTicket) {
    fun checkTicket(lottoTicket: LottoTicket): WinningResult {
        val matchNumbers = winningTicket.numbers intersect lottoTicket.numbers.toSet()
        return WinningResult.valueOf(matchNumbers.size)
    }
}
