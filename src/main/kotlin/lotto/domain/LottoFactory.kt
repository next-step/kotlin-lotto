package lotto.domain

object LottoFactory {
    const val LOTTE_PRICE = 1000
    fun purchaseLotto(amount: Int): LottoTicket {
        val lottoCount: Int = LOTTE_PRICE / amount
        return LottoTicket(lottoCount)
    }
}
