package lotto.domain

class Wallet(private val money: Int) {
    fun getAbleToBuyAutoLottoCounts(manualLottoCounts: Int = 0): Int = (money / Lotto.PRICE) - manualLottoCounts
}
