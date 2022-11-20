package lotto.domain

object LottoFactory {
    const val LOTTE_PRICE = 1000
    fun purchaseLotto(amount: Int): List<Lotto> {
        val lottoCount: Int = amount / LOTTE_PRICE
        return List(lottoCount) { Lotto() }
    }
}
