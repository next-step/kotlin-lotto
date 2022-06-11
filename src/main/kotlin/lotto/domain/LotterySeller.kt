package lotto.domain

import lotto.vo.LotteryNumberSet
import lotto.vo.LotterySet
import lotto.vo.Money

class LotterySeller(private val lotteryStore: LotteryStore) {

    fun sell(wallet: Wallet, count: Int): LotterySet {
        wallet.withdraw(calculateLotteryAmount(count))
        return lotteryStore.getLotteries(count)
    }

    fun sellManually(wallet: Wallet, lotteryNumberSets: List<LotteryNumberSet>): LotterySet {
        wallet.withdraw(calculateLotteryAmount(lotteryNumberSets.size))
        return lotteryStore.getManualLotteries(lotteryNumberSets)
    }

    private fun calculateLotteryAmount(count: Int) = Money(Lottery.PRICE * count)
}
