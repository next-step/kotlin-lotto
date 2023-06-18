package lotto.domain

class MyLotteryGroup(lotteries: List<Lottery>, handCount: Int, machineCount: Int) : LotteryGroup(lotteries) {
    val lotteryHandCount: LotteryCount
    val lotteryMachineCount: LotteryCount
    init {
        lotteryHandCount = LotteryCount(handCount)
        lotteryMachineCount = LotteryCount(machineCount)
    }
}
