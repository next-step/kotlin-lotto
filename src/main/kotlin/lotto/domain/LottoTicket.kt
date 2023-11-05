package lotto.domain

class LottoTicket(
    val ticketAmount: Amount,
    val lottos: List<LottoNumbers>
) {

    fun getMatchCount(winningNumber: LottoNumbers): List<Int> = lottos.map { winningNumber.getMatchCount(it) }
}
