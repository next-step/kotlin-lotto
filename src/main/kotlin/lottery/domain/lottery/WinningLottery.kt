package lottery.domain.lottery

import lottery.domain.Rank

class WinningLottery(
    val lottery: Lottery,
    val bonusNumber: LotteryNumber
) {
    init {
        require(lottery.containsLotteryNumber(bonusNumber).not()) { "당첨 번호와 보너스 번호는 동일할 수 없다" }
    }

    fun compareLottery(lottery: Lottery): Rank =
        Rank.of(this.lottery.matchCount(lottery), lottery.containsLotteryNumber(bonusNumber))
}
