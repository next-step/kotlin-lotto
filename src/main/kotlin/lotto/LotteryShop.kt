package lotto

class LotteryShop {

    fun buy(money: Int): Int {
        return money / LOTTERY_PRICE
    }

    companion object {
        private const val LOTTERY_PRICE = 1000
    }
}
