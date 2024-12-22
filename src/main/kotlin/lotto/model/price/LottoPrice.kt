package lotto.model.price

interface LottoPrice {
    val price: Int

    fun calculateLottoCount(purchaseAmount: Int): Int
}
