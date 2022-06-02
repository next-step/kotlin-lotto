package lotto.domain

class WinningMatcher(private val winner: Lotto, private val bonus: LottoNumber) {

    fun getPlace(lotto: Lotto): Winning {
        val matchBonus = bonus in lotto
        return Winning.of(winner.countMatches(lotto), matchBonus)
    }
}
