package lotto.policy

import lotto.domain.Lottery
import lotto.domain.LotteryNumberSet
import lotto.vo.LotteryRank

abstract class LotteryPolicy(private val lotteryNumberSet: LotteryNumberSet) {

    protected fun matchCount(lottery: Lottery) =
        lotteryNumberSet.map(lottery::contains).filter { it }.size

    abstract fun match(lottery: Lottery): LotteryRank
}
