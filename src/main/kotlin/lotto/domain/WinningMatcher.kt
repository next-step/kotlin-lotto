package lotto.domain

class WinningMatcher(private val winner: Lotto, private val bonus: LottoNumber) {

    fun getPlace(lotto: Lotto): Winning {
        val matchBonus = lotto.contains(bonus)
        return Winning.of(winner.countMatches(lotto), matchBonus)
    }
}
