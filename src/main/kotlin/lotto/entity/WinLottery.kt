package lotto.entity

private const val rewardThree = 5000
private const val rewardFour = 50000
private const val rewardFive = 1500000
private const val rewardSix = 2000000000

data class WinLottery(var matchNum: Int = 0, val reward: Int, val count: Int = 0)
data class WinLotteryResult(
    var matchThree: WinLottery = WinLottery(0, rewardThree),
    var matchFour: WinLottery = WinLottery(0, rewardFour),
    var matchFive: WinLottery = WinLottery(0, rewardFive),
    var matchSix: WinLottery = WinLottery(0, rewardSix)
)
