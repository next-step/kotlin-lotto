package lotto.domain

class WinningLotto(val numbers: LottoNumbers, val bonusNumber: Int) {
    val size: Int
        get() = numbers.size

    fun rank(lotto: Lotto): Rank {
        val countOfMatch = countMatch(lotto)
        val matchBonus = matchBonus(lotto)
        return Rank.of(countOfMatch, matchBonus)
    }

    private fun countMatch(lotto: Lotto): Int {
        return numbers.countMatch(lotto.numbers)
    }

    private fun matchBonus(lotto: Lotto): Boolean {
        return lotto.numbers.match(bonusNumber)
    }
}
