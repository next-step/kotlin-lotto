package lotto

class LottoTicket private constructor(
    val lottoNumber: LottoNumber,
    lottoStatus: LottoStatus = LottoStatus.WAITING,
    matchCount: Int = 0,
) {
    var lottoStatus = lottoStatus
        private set
    var matchCount = matchCount
        private set

    fun match(winningNumber: WinningNumber) {
        val matchCount = lottoNumber.matchCount(winningNumber = winningNumber)
        this.lottoStatus = LottoStatus.from(matchCount = matchCount)
        this.matchCount = matchCount
    }

    companion object {
        private const val LOTTO_TICKET_PRICE = 1000

        fun purchase(payment: Int, manualNumber: LottoNumber? = null): LottoTicket {
            require(payment == LOTTO_TICKET_PRICE)
            val lottoNumber = manualNumber ?: LottoNumber.autoGenerate()
            return LottoTicket(lottoNumber = lottoNumber)
        }
    }
}
