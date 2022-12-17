package lotto

class LottoTicket private constructor(
    val lottoNumber: LottoNumber,
    status: LottoTicketStatus = LottoTicketStatus.WAITING,
    matchCount: Int = 0,
) {
    var status = status
        private set
    var matchCount = matchCount
        private set

    fun match(winningNumber: WinningNumber) {
        val matchCount = lottoNumber.matchCount(winningNumber = winningNumber)
        this.status = LottoTicketStatus.from(matchCount = matchCount)
        this.matchCount = matchCount
    }

    companion object {
        const val LOTTO_TICKET_PRICE = 1000

        fun purchase(payment: Int, manualNumber: LottoNumber? = null): LottoTicket {
            require(payment == LOTTO_TICKET_PRICE)
            val lottoNumber = manualNumber ?: LottoNumber.autoGenerate()
            return LottoTicket(lottoNumber = lottoNumber)
        }
    }
}
