package lotto.domain

class WinningLotto(val lotto: Lotto, val bonusNumber: LottoNumber) {
    init {
        require(!lotto.match(bonusNumber)) { "보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }

    val size: Int
        get() = lotto.size

    fun rank(lotto: Lotto): Rank {
        val countOfMatch = this.lotto.countMatch(lotto)
        val matchBonus = lotto.match(bonusNumber)
        return Rank.of(countOfMatch, matchBonus)
    }
}
