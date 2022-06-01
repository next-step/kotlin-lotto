package lotto.policy

import lotto.domain.Lottery
import lotto.vo.LotteryNumberSet
import lotto.vo.LotteryRank

class NormalLotteryPolice(winningLotteryNumbers: LotteryNumberSet) : LotteryPolicy(winningLotteryNumbers) {

    override fun match(lottery: Lottery): LotteryRank = LotteryRank.of(matchCount(lottery))
}
