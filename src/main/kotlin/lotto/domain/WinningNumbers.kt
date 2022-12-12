package lotto.domain

data class WinningNumbers(val lotto: Lotto, val bonusNumber: LottoNumber) {
    init {
        require(!lotto.contains(bonusNumber)) { "보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }

    fun getLottoRank(lotto: Lotto): LottoRank {
        val countOfMatch = lotto.getCountOfMatches(this.lotto)
        val matchBonus = lotto.contains(bonusNumber)
        return LottoRank.valueOf(countOfMatch, matchBonus)
    }
}
