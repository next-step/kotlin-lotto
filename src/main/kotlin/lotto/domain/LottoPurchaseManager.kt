package lotto.domain

class LottoPurchaseManager {

    fun getLottoCount(money: Int): Int = money.div(LOTTO_PRICE)

    companion object {
        private const val LOTTO_PRICE = 1000

    }
}
