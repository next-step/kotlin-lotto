package lotto.domain

class LottoShop(
    private val purchasePrice: Int
) {
    fun sellLotto(): List<Lotto> {
        val lottoCount = getBuyLottoCount(purchasePrice)
        return buildList(lottoCount) {
            List(lottoCount) {add(Lotto())}
        }
    }

    private fun getBuyLottoCount(purchasePrice: Int): Int {
        return purchasePrice / LOTTO_PRICE
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
