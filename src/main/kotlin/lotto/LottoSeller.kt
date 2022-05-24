package lotto

object LottoSeller {
    private const val LOTTO_PRICE = 1000

    fun enableSellLottoCount(money: Int): Int = (money / LOTTO_PRICE)
}
