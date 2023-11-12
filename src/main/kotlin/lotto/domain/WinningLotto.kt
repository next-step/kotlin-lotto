package lotto.domain

data class WinningLotto(val lotto: Lotto, val bonusNumber: LottoNumber) {

    constructor(numbers: List<Int>, bonusNumber: Int) : this(Lotto(numbers), LottoNumber.from(bonusNumber))

    fun calculateRank(other: Lotto): Rank {
        val matchCount = lotto.calculateMatchCount(other)
        val matchBonus = other.contains(bonusNumber)
        return Rank.from(matchCount, matchBonus)
    }
}
