package lotto

class LottoStore(private val input: Long) {
    fun getAbleToPurchaseCount(): Long {
        return input.div(LOTTO_UNIT_PRICE)
    }

    companion object {
        const val LOTTO_UNIT_PRICE = 1000L
    }
}