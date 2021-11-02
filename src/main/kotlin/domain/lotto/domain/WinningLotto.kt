package domain.lotto.domain

import global.strategy.split.SplitStrategy

class WinningLotto(val winningLotto: Lotto, val bonusBall: LottoNumber) {

    companion object {
        fun from(winningLotto: String, bonusBall: Int, splitStrategy: SplitStrategy): WinningLotto =
            WinningLotto(Lotto.of(winningLotto, splitStrategy), LottoNumber.of(bonusBall))

        fun from(winningLotto: Lotto, bonusBall: LottoNumber): WinningLotto = WinningLotto(winningLotto, bonusBall)
    }
}