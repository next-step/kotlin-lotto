package lotto.application.vo

private const val LOTTO_PRICE = 1000

data class Purchase(
    val amount: Amount
) {
    val lottoPurchaseCount: Int = (amount.value / LOTTO_PRICE).toInt()
}
