import domain.Lottery

object LotteryMachine {

    fun buyAutomaticLotteries(automaticSize: Int, lotteries: MutableList<Lottery>) {
        for (idx in 1..automaticSize) {
            lotteries.add(Lottery())
        }
    }

    fun checkManualSize(money: Int, manualSize: Int) {
        require(money / 1000 >= manualSize) { "${manualSize}수동 구매 수량은 ${money / 1000}보다 작아야 합니다." }
    }
}
