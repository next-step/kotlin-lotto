package lotto

class LottoVendor {
    fun sellLotto(price: Price): List<Lotto> {
        val number = getNumberOfLotto(price)
        return LottoBuilder().create(number)
    }

    fun getNumberOfLotto(price: Price): Int {
        return price.amount / LOTTO_PRICE
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
