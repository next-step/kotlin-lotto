package lotto.domain

class Checker(private val lastNumbers: LottoTicket) {
    fun match(lottoTicket: LottoTicket): Int =
        lottoTicket.numbers.intersect(lastNumbers.numbers.toSet()).size
}
