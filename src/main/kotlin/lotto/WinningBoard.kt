package lotto

class WinningBoard(val winningTicket: LottoTicket) {
    fun checkTicket(lottoTicket: LottoTicket): Int {
        val matchNumbers = winningTicket.numbers intersect lottoTicket.numbers.toSet()
        return matchNumbers.size
    }
}
