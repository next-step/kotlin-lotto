package lotto.domain

class WinningLotto(
    private val winningNumbers: Set<LottoNumber>,
    private val bonusNumber: LottoNumber
) : Lotto(winningNumbers) {

    private var numOfMatch = 0
    private var bonusMatch = false

    fun rankOfLotto(lotto: Lotto): LottoRank {
        numOfMatch = winningNumbers.intersect(lotto.lottoNumbers).count()
        bonusMatch = lotto.lottoNumbers.contains(bonusNumber)
        return LottoRank.of(numOfMatch, bonusMatch)
    }

}
