package lotto.domain

object LottoFactory {
    fun buyLotto(money: Int): List<Lotto> {
        val lottoCount = money / Lotto.LOTTO_PRICE
        return List(lottoCount) { Lotto() }
    }
}
