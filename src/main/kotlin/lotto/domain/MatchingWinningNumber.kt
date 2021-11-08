package lotto.domain

class MatchingWinningNumber(val winningNumberCount: Int, val bonusNumber: Boolean) {

    companion object {
        fun of(
            lottoNumbers: LottoNumbers,
            winningLottoNumbers: LottoNumbers,
            bonusNumber: LottoNumber
        ): MatchingWinningNumber {
            val matchingCount = lottoNumbers.getMatchingCount(winningLottoNumbers)
            val isBonus = lottoNumbers.isBonusNumber(bonusNumber)
            return MatchingWinningNumber(matchingCount, isBonus)
        }
    }
}
