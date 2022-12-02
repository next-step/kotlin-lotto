package lotto.model

private const val LOTTO_PER_AMOUNT = 1000

@JvmInline
value class PurchaseAmount(val amount: Int) {

    fun count(): Int = amount / LOTTO_PER_AMOUNT
}
