package lotto.domain

class LottoTicketIssuer(
    private val lottoTicketPrice: Long = LottoTicket.LOTTO_TICKET_PRICE
) {

    fun issueLottoByAuto(purchaseMoney: Long): List<LottoTicket> {

        require(purchaseMoney >= 0) { "구입금액은 0원보다 커야합니다." }
        val lottoAmount = (purchaseMoney / lottoTicketPrice).toInt()

        return List(lottoAmount) { LottoTicket.issueByAuto() }
    }
}
