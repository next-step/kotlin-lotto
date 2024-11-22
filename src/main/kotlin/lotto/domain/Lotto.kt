package lotto.domain

class Lotto(val purchasePrice: Int) {
    fun getLottoPurchaseCount(): Int {
        return purchasePrice / LOTTO_PRICE
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
