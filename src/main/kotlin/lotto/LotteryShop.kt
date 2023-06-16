package lotto

class LotteryShop {

    fun buy(money: Int): Int {
        if (money == 1000) return money
        else throw IllegalArgumentException()
    }
}
