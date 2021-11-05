package lotto.domain

class MatchingWinningNumber(val winningNumberCount: Int, val bonusNumber: Boolean) {

    companion object {
        fun of(lottoNumbers: List<Int>, winningNumbers: List<Int>, bonusNumber: Int): MatchingWinningNumber {
            val winningNumberCount = lottoNumbers.intersect(winningNumbers).count()
            val isBonus = lottoNumbers.contains(bonusNumber)
            return MatchingWinningNumber(winningNumberCount, isBonus)
        }
    }
}
