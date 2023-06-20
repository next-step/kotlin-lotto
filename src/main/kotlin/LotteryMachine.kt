import domain.Lottery

object LotteryMachine {

    fun buyAutomaticLotteries(automaticSize: Int, existingLotteries: List<Lottery>): List<Lottery> {
        val newLotteries = List(automaticSize) { Lottery() }
        return existingLotteries + newLotteries
    }

    fun checkManualSize(money: Int, manualSize: Int) {
        require(money / 1000 >= manualSize) { "${manualSize}수동 구매 수량은 ${money / 1000}보다 작아야 합니다." }
    }
}
