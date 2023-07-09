package lotto.domain

class WinningLotto(val lottoNumbers: LottoNumbers, val bonusNumber: Int) {
    val size: Int
        get() = lottoNumbers.size

    fun rank(lottoNumbers: LottoNumbers): Rank {
        val countOfMatch = countMatch(lottoNumbers)
        val matchBonus = matchBonus(lottoNumbers)
        return Rank.of(countOfMatch, matchBonus)
    }

    private fun countMatch(lottoNumbers: LottoNumbers): Int {
        return this.lottoNumbers.countMatch(lottoNumbers)
    }

    private fun matchBonus(lottoNumbers: LottoNumbers): Boolean {
        return lottoNumbers.match(bonusNumber)
    }
}
