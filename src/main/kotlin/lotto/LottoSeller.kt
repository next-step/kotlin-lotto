package lotto

object LottoSeller {
    const val LOTTO_PRICE = 1000

    fun enableSellLottoCount(money: Int): Int = (money / LOTTO_PRICE)

    fun sellLotto(enableLottoPurchaseCount: Int): List<Lotto> {
        return List(enableLottoPurchaseCount) { Lotto().apply { processLotto() } }
    }
}
