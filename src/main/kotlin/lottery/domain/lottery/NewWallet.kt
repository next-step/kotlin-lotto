package lottery.domain.lottery

import lottery.domain.Money
import lottery.domain.lottery.Lotteries.Companion.init
import lottery.domain.lottery.generator.LotteryGenerator

class NewWallet(
    var money: Money,
    val lotteries: Lotteries = init()
) {
    fun buyLotteries(randomLotteryGenerator: LotteryGenerator) {
        check(Lottery.canBuyLottery(money)) { "로또를 사기엔 부족한 금액이다" }
    }
}
