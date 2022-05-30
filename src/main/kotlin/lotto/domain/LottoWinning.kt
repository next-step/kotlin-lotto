package lotto.domain

class LottoWinning(
    private val numbers: List<LottoNumber>,
    private val bonusNumber: LottoNumber
) {

    private fun matchCount(ticket: LottoTicket): Int {
        return numbers.intersect(ticket.numbers.toSet()).size
    }

    private fun isMatchBonus(ticket: LottoTicket, bonusNumber: LottoNumber): Boolean {
        return bonusNumber in ticket.numbers
    }

    private fun getPrize(ticket: LottoTicket): LottoPrize {
        return LottoPrize.of(
            matchCount = matchCount(ticket),
            matchBonus = isMatchBonus(ticket, bonusNumber),
        )
    }

    fun getPrizes(lottoTickets: LottoTickets): LottoPrizes {
        return LottoPrizes(
            lottoTickets.lottoTickets.map {
                getPrize(it)
            }
        )
    }
}
