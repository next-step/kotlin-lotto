package lotto.domain

class MatchingWinningNumber(val winningNumberCount: Int, val bonusNumber: Boolean) {

    companion object {
        fun of(
            lotto: Lotto,
            winningLottoNumbers: LottoNumbers,
            bonusNumber: LottoNumber
        ): MatchingWinningNumber {
            val lottoNumbers = lotto.getLottoNumbers()
            val matchingCount = lottoNumbers.getMatchingCount(winningLottoNumbers)
            val isBonus = lottoNumbers.isBonusNumber(bonusNumber)
            return MatchingWinningNumber(matchingCount, isBonus)
        }
    }
}
