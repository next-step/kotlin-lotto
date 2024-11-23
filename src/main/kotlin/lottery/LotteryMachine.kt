package lottery

class LotteryMachine {
    companion object {
        fun buy(count: Int): List<Lottery> {
            return List(count) { Lottery.create() }
        }
    }
}
