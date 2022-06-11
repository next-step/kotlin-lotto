package lotto.domain

import lotto.vo.LotterySet
import lotto.vo.Money

class LotterySeller(private val lotteryStore: LotteryStore) {

    fun sell(wallet: Wallet, count: Int): LotterySet {
        wallet.withdraw(calculateLotteryAmount(count))
        return lotteryStore.getLotteries(count)
    }

    private fun calculateLotteryAmount(count: Int) = Money(Lottery.PRICE * count)
}
