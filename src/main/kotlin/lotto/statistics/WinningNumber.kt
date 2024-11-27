package lotto.statistics

import lotto.Lotto
import lotto.ball.BonusBall
import lotto.number.Numbers

class WinningNumber(
    val numbers: Numbers,
    val bonusBall: BonusBall,
) {
    fun countMatchingNumbers(lotto: Lotto): Int = numbers.countMatching(lotto.numbers)
}
