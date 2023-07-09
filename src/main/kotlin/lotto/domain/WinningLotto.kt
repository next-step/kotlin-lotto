package lotto.domain

class WinningLotto(val lotto: Lotto, val bonusNumber: LottoNumber) {
    init {
        require(!lotto.match(bonusNumber)) { "보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }

    val size: Int
        get() = lotto.size

    fun rank(lotto: Lotto): Rank {
        val countOfMatch = countMatch(lotto)
        val matchBonus = matchBonus(lotto)
        return Rank.of(countOfMatch, matchBonus)
    }

    private fun countMatch(lotto: Lotto): Int {
        return this.lotto.countMatch(lotto)
    }

    private fun matchBonus(lotto: Lotto): Boolean {
        return lotto.match(bonusNumber)
    }
}
