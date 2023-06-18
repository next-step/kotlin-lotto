package lotto.domain.lottery

import lotto.domain.WinnerPrize

class WinnerLottery(numbers: Set<LotteryNumber>, private val bonus: LotteryNumber) : Lottery(numbers) {
    init {
        require(this.bonus !in numbers) { "bonus 값은 당첨 번호와 중복 될 수 없습니다. bonus : $bonus" }
    }

    fun calculatePrize(lottery: Lottery): WinnerPrize {
        val matchNumbers = this intersect lottery
        return WinnerPrize.getWinnerPrize(matchNumbers.size, lottery.isInBonus(bonus))
    }
}
