package lotto.domain.lottery

import lotto.domain.WinnerPrize

class WinnerLottery(numbers: Set<Int>, private val bonus: Int) : Lottery(numbers) {
    init {
        require(bonus in LOTTERY_NUMBER_RANGE) { "bonus 값은 로또의 숫자는 1~45 사이의 정수가 가능합니다. bonus : $bonus" }
        require(bonus !in numbers) { "bonus 값은 당첨 번호와 중복 될 수 없습니다. bonus : $bonus" }
    }

    fun calculatePrize(lottery: Lottery): WinnerPrize {
        val matchNumbers = this intersect lottery
        return WinnerPrize.getWinnerPrize(matchNumbers.size, lottery.isInBonus(bonus))
    }
}
