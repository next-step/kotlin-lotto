package lotto

object LottoSeller {
    const val LOTTO_PRICE = 1000

    fun ableSellLottoCount(money: Int): Int = (money / LOTTO_PRICE)

    fun sellLotto(ableLottoPurchaseCount: Int): List<Lotto> {
        return List(ableLottoPurchaseCount) { Lotto().apply { processLotto() } }
    }
}
