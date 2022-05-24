package lotto

object LottoSeller {
    private const val LOTTO_PRICE = 1000

    fun enableSellLottoCount(money: Int): Int = (money / LOTTO_PRICE)

    fun sellLotto(money: Int): List<Lotto> {
        val lottoCount: Int = enableSellLottoCount(money)
        return List(lottoCount) { Lotto().apply { processLotto() } }
    }
}
