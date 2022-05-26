package lotto.domain

class Checker(private val lastNumbers: LottoTicket) {
    fun match(lottoTicket: LottoTicket): Int =
        lottoTicket.numbers.filter { it in lastNumbers.numbers }.size
}
