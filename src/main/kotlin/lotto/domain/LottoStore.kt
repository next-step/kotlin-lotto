package lotto.domain

object LottoStore {
    fun buyLottos(inputPrice: Int): List<Lotto> {
        val lottoCount = inputPrice / LOTTO_PRICE
        return (1..lottoCount).map { Lotto() }
    }

    const val LOTTO_PRICE = 1000
}
