package com.nextstep.lotto.domain

data class WinningLotto(val winningLotto: Lotto) {

    fun findNumberOfMatch(lotto: Lotto): Int {
        return lotto.lottoNumbers.count { winningLotto.lottoNumbers.contains(it) }
    }
}
