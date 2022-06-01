package lotto.policy

import lotto.domain.Lottery
import lotto.vo.LotteryNumber
import lotto.vo.LotteryNumberSet
import lotto.vo.LotteryRank

class BonusLotteryPolicy(winningLotteryNumbers: LotteryNumberSet, private val bonus: LotteryNumber) :
    LotteryPolicy(winningLotteryNumbers) {

    init {
        require(!winningLotteryNumbers.contains(bonus)) { "보너스 번호가 중첩될 수 없습니다." }
    }

    override fun match(lottery: Lottery): LotteryRank {
        if (isOnePlace(lottery)) return LotteryRank.ONE_PLACE
        if (isBonusPlace(lottery)) return LotteryRank.BONUS_TWO_PLACE
        return LotteryRank.of(matchCount(lottery))
    }

    private fun isMatchBonusNumber(lottery: Lottery) = lottery.contains(bonus)

    private fun isBonusPlace(lottery: Lottery): Boolean {
        val count = LotteryRank.of(matchCount(lottery))

        if (LotteryRank.FOUR_PLACE == count && isMatchBonusNumber(lottery)) {
            return true
        }
        return false
    }

    private fun isOnePlace(lottery: Lottery): Boolean =
        LotteryRank.of(matchCount(lottery)) == LotteryRank.ONE_PLACE
}
