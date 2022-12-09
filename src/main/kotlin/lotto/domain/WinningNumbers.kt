package lotto.domain

data class WinningNumbers(val lottoNumbers: LottoNumbers, val bonusNumber: LottoNumber) {
    init {
        require(!lottoNumbers.contains(bonusNumber)) { "보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }

    fun getLottoRank(lottoNumbers: LottoNumbers): LottoRank {
        val countOfMatch = lottoNumbers.getCountOfMatches(this.lottoNumbers)
        val matchBonus = lottoNumbers.contains(bonusNumber)
        return LottoRank.valueOf(countOfMatch, matchBonus)
    }
}
