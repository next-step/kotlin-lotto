package lotto.domain

import lotto.domain.LottoRule.LOTTO_NUMBER_COUNT
import lotto.domain.LottoRule.LOTTO_PRICE

class LottoTickets(private val lottoTickets: List<LottoTicket> = emptyList()) {
    val money = Money(lottoTickets.size * LOTTO_PRICE)

    val ticketSize = lottoTickets.size

    fun <R> toMap(transform: (LottoTicket) -> R): List<R> = lottoTickets.map {
        transform(it)
    }

    operator fun plus(lottoTickets: LottoTickets): LottoTickets =
        LottoTickets(lottoTickets.lottoTickets + lottoTickets.lottoTickets)
}

class LottoTicket(private val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) {
            NOT_MATCH_NUMBER_COUNT
        }
    }

    val set = numbers.toSet()
    val sortedNumbers = numbers.sortedBy { it.number }
    fun contain(lottoNumber: LottoNumber) = lottoNumber in numbers


    companion object {
        private const val NOT_MATCH_NUMBER_COUNT = "로또 번호는 $LOTTO_NUMBER_COUNT 개의 숫자로 구성되어야 합니다"
    }
}
