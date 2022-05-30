package lotto.domain

class LottoTicket(private val lottoNumber: LottoNumber) {
    val numbers: Set<Int> = lottoNumber.numbers

    fun matchCount(winningTicket: LottoTicket): Int {
        return numbers.filter { winningTicket.numbers.contains(it) }.size
    }

    fun addBonusNumber(number: Int) {
        lottoNumber.addBonusNumber(number)
    }
}
