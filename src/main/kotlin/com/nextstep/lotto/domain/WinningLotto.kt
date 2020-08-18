package com.nextstep.lotto.domain

class WinningLotto(val winningLotto: Lotto) {

    companion object {
        fun generate(lottoNumbers: List<Int>): WinningLotto {
            return WinningLotto(LottoFactory.drawManualLotto(lottoNumbers))
        }
    }
}
