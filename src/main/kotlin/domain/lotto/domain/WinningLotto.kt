package domain.lotto.domain

import domain.lotto.error.DuplicateBonusBallNumberException
import global.strategy.split.SplitStrategy

data class WinningLotto private constructor(val winningLotto: Lotto, val bonusBall: LottoNumber) {

    fun isMatchBonusBall(lotto: Lotto): Boolean = lotto.contains(bonusBall)

    fun match(lotto: Lotto): Int {
        if (isMatchBonusBall(lotto)) {
            return Math.addExact(winningLotto.match(lotto), BONUS_BALL_COUNT)
        }
        return winningLotto.match(lotto)
    }

    companion object {
        private const val BONUS_BALL_COUNT = 1

        fun from(winningLotto: String, bonusBall: Int, splitStrategy: SplitStrategy): WinningLotto =
            from(Lotto.of(winningLotto, splitStrategy), LottoNumber.of(bonusBall))

        fun from(winningLotto: Lotto, bonusBall: LottoNumber): WinningLotto {
            validateDuplicateNumber(winningLotto, bonusBall)
            return WinningLotto(winningLotto, bonusBall)
        }

        private fun validateDuplicateNumber(winningLotto: Lotto, bonusBall: LottoNumber) {
            if (winningLotto.contains(bonusBall)) {
                throw DuplicateBonusBallNumberException(bonusBall.lottoNumber)
            }
        }
    }
}
