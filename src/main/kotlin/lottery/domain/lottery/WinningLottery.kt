package lottery.domain.lottery

class WinningLottery(
    val lottery: Lottery,
    val bonusNumber: LotteryNumber
) {
    init {
        check(lottery.containsLotteryNumber(bonusNumber).not()) { "당첨 번호와 보너스 번호는 동일할 수 없다" }
    }
}
