package lotto.domain

import lotto.domain.LottoTicketGenerator.Companion.NUMBERS_COUNT
import lotto.domain.LottoTicketGenerator.Companion.NUMBERS_RANGE

class LottoTickets(val tickets: List<LottoTicket>) {

    fun determineResultBy(winningTicket: WinningLottoTicket): LottoRankCounts {
        // 정지
        return tickets.map { ticket -> ticket.determineRankBy(winningTicket) }
                .groupingBy { it }
                .eachCount()
                .let(::LottoRankCounts)
    }

    fun calculateTotalPriceBy(ticketPrice: Int): Int {
        return tickets.size * ticketPrice
    }
}


class LottoTicket(val lottoNumbers: List<LottoNumber>) {
    init {
        require(lottoNumbers.size == NUMBERS_COUNT) { "로또 번호는 ${NUMBERS_COUNT}개여야 합니다." }
        require(lottoNumbers.distinct().size == NUMBERS_COUNT) { "로또 번호는 중복될 수 없습니다." }
    }

    fun determineRankBy(ticket: WinningLottoTicket): Rank {
        val count = lottoNumbers.intersect(ticket.winningLottoTicket.lottoNumbers.toSet()).count()
        return Rank.from(count)
    }
}

@JvmInline
value class LottoNumber(private val number: Int) {
    init {
        require(number in NUMBERS_RANGE) { "로또 번호는 1~45 사이의 숫자여야 합니다." }
    }

    override fun toString(): String {
        return number.toString()
    }
}
