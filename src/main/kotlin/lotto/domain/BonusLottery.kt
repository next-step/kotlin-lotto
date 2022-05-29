package lotto.domain

import lotto.vo.LotteryRank

class BonusLottery(numbers: List<Int>, private val bonus: Int) : Lottery<BonusLottery>(numbers) {

    init {
        require(isValidNumber(bonus))
    }

    override fun match(other: BonusLottery): LotteryRank {
        val count = countMatchNumbers(other)
        val rank = LotteryRank.of(count)

        if (isBonusPlace(rank, other)) {
            return LotteryRank.BONUS_TWO_PLACE
        }
        return rank
    }

    private fun countMatchNumbers(other: BonusLottery): Int {
        val count = countingMatchNumber(other)
        if (isOnePlace(count)) {
            return count
        }
        return count + if (isEqualBonusNumber(other)) 1 else 0
    }

    private fun isOnePlace(count: Int) = LOTTO_NUMBER_LENGTH == count

    private fun isEqualBonusNumber(other: BonusLottery) = bonus == other.bonus

    private fun isBonusPlace(rank: LotteryRank, other: BonusLottery) =
        rank == LotteryRank.TWO_PLACE && isEqualBonusNumber(other)
}
