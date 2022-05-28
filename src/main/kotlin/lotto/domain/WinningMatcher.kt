package lotto.domain

class WinningMatcher(private val winner: Lotto) {

    fun getPlace(lotto: Lotto): Winning {
        return Winning.of(getMatchCount(lotto))
    }

    private fun getMatchCount(lotto: Lotto): Int = winner.numbers.count { lotto.numbers.contains(it) }
}
