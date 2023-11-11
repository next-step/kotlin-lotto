class Lotto {

    fun getMaxPurchaseCnt(cash: Int): Int {
        return cash / LOTTO_PRICE
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
