package lotto

class LottoTicket private constructor(val lottoNumber: LottoNumber) {
    companion object {
        private const val LOTTO_TICKET_PRICE = 1000

        fun purchase(payment: Int): LottoTicket {
            require(payment == LOTTO_TICKET_PRICE)
            val lottoNumber = LottoNumber.autoGenerate()
            return LottoTicket(lottoNumber = lottoNumber)
        }
    }
}
