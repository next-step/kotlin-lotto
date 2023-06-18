package lotto.domain

class LottoShop(
    private val purchasePrice: Int
) {
    private fun getBuyLottoCount(purchasePrice: Int): Int {
        return purchasePrice / LOTTO_PRICE
    }

    fun sellLotto(): List<Lotto> {
        val lottoCount = getBuyLottoCount(purchasePrice)
        return (0 until lottoCount).map { Lotto() }
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
