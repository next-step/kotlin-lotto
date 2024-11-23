package lottery

object LotteryMachine {
    fun buy(money: Money): List<Lottery> {
        val buyCount = getBuyCount(money)
        return List(buyCount) { Lottery.create() }
    }

    private fun getBuyCount(money: Money): Int {
        validate(money)
        return money.amount / 1000
    }

    private fun validate(money: Money) {
        if (money.amount % 1000 != 0) {
            throw IllegalArgumentException("단위는 1000원으로 입력해야 합니다")
        }
    }
}
