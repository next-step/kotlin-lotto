package lotto

class Receipt(private val payment: Int) {
    val lottoCount
        get() = payment / LOTTO_PRICE

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
