package lottery

object LotteryMachine {
    fun buy(count: Int): List<Lottery> {
        return List(count) { Lottery.create() }
    }
}
