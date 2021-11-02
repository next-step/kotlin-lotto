package domain.lotto.domain

import domain.lotto.error.DuplicateBonusBallNumberException
import global.strategy.split.SplitStrategy

data class WinningLotto(val winningLotto: Lotto, val bonusBall: LottoNumber) {

    companion object {
        fun from(winningLotto: String, bonusBall: Int, splitStrategy: SplitStrategy): WinningLotto =
            from(Lotto.of(winningLotto, splitStrategy), LottoNumber.of(bonusBall))

        fun from(winningLotto: Lotto, bonusBall: LottoNumber): WinningLotto {
            validateDuplicateNumber(winningLotto, bonusBall)
            return WinningLotto(winningLotto, bonusBall)
        }

        private fun validateDuplicateNumber(winningLotto: Lotto, bonusBall: LottoNumber) {
            if(winningLotto.contains(bonusBall)) {
                throw DuplicateBonusBallNumberException(bonusBall.lottoNumber)
            }
        }
    }
}
