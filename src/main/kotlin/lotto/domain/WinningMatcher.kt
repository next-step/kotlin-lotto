package lotto.domain

class WinningMatcher(private val winnerLotto: WinnerLotto) {

    fun getPlace(lotto: Lotto): Winning {
        val matchBonus = winnerLotto.bonus in lotto
        return Winning.of(winnerLotto.winner.countMatches(lotto), matchBonus)
    }
}
