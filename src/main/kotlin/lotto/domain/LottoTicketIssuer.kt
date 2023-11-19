package lotto.domain

class LottoTicketIssuer(
    private val lottoTicketPrice: Long = LottoTicket.LOTTO_TICKET_PRICE
) {

    fun issueLottoByAuto(money: Long): List<LottoTicket> {
        val lottoAmount = (money / lottoTicketPrice).toInt()
        return List(lottoAmount) { LottoTicket.issueByAuto() }
    }
}
