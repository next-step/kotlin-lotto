package lottery

object LotteryMachine {
    fun buy(money: Money): List<Lottery> {
        val buyCount = getBuyCount(money)
        return List(buyCount) { Lottery.create() }
    }

    private fun getBuyCount(money: Money): Int {
        require(money.amount >= 1000) { "금액은 1000원 이상이어야 합니다" }
        require(money.amount % 1000 == 0) { "금액은 1000원 단위여야 합니다" }
        return money.amount / 1000
    }
}
