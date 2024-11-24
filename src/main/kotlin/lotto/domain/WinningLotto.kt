package lotto.domain

class WinningLotto(private val winnerLine: LottoLine, private val bonusBall: LottoBall) {
    fun match(otherLine: LottoLine): Pair<Int, Boolean> {
        val matchCount = otherLine.extractMatchCount(winnerLine)
        val bonusMatch = otherLine.containBonusBall(bonusBall)
        val adjustedMatchCount = adjustMatchCountWithBonus(matchCount, bonusMatch)
        return Pair(adjustedMatchCount, bonusMatch)
    }

    private fun adjustMatchCountWithBonus(
        matchCount: Int,
        bonusMatch: Boolean,
    ): Int {
        return if (bonusMatch) matchCount + 1 else matchCount
    }

    companion object {
        fun makeWinningLotto(
            winningBalls: LottoBalls,
            bonusNumber: LottoBall,
        ): WinningLotto {
            validateDuplicateBall(winningBalls, bonusNumber)
            return WinningLotto(LottoLine(winningBalls), bonusNumber)
        }

        private fun validateDuplicateBall(
            winningBalls: LottoBalls,
            bonusNumber: LottoBall,
        ) {
            require(!winningBalls.contains(bonusNumber)) { "보너스 번호는 당첨 번호와 중복될 수 없습니다." }
        }
    }
}
