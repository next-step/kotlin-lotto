package lotto

interface LottoPurchaseCommand {
    fun fetchPurchaseLottoByCount(count: Int): List<Lotto>
}
