package lotto.domain

class MatchingWinningNumber(val winningNumberCount: Int, val bonusNumber: Boolean) {

    companion object {
        fun of(
            lottoNumbers: LottoNumbers,
            winningLotto: LottoNumbers,
            bonusNumber: LottoNumber
        ): MatchingWinningNumber {
            val winningNumberCount = lottoNumbers.toInts().intersect(winningLotto.toInts()).count()
            val isBonus = lottoNumbers.toInts().contains(bonusNumber.toInt())
            return MatchingWinningNumber(winningNumberCount, isBonus)
        }
    }
}
