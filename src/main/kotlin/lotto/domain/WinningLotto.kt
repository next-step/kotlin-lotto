package lotto.domain

class WinningLotto(
    winningNumbers: Set<LottoNumber>,
    private val bonusNumber: LottoNumber
) : Lotto(winningNumbers) {

    init {
        require(!winningNumbers.contains(bonusNumber))
    }

    fun rankOfLotto(lotto: Lotto): LottoRank {
        val numOfMatch = lottoNumbers.intersect(lotto.lottoNumbers).count()
        val bonusMatch = lotto.lottoNumbers.contains(bonusNumber)
        return LottoRank.of(numOfMatch, bonusMatch)
    }

}
