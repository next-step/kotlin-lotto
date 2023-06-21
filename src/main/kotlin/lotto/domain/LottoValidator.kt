package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.SelectedBalls

class LottoValidator(private val selectedBalls: SelectedBalls) {

    fun getPrize(lotto: Lotto): Lotto.Prize {
        val hasBonusBall = lotto.numbers.contains(selectedBalls.bonus)
        val matchCount = lotto.numbers.filter { it in selectedBalls.winningNumbers.balls }.size
        return when (matchCount) {
            Lotto.Prize.SIX_MATCH.matches -> Lotto.Prize.SIX_MATCH
            Lotto.Prize.FIVE_MATCH.matches -> if (hasBonusBall) Lotto.Prize.FIVE_MATCH_PLUS_BONUS else Lotto.Prize.FIVE_MATCH
            Lotto.Prize.FOUR_MATCH.matches -> Lotto.Prize.FOUR_MATCH
            Lotto.Prize.THREE_MATCH.matches -> Lotto.Prize.THREE_MATCH
            else -> Lotto.Prize.NOTHING
        }
    }
}
