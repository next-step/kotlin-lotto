package com.nextstep.lotto.domain

data class WinningLotto(val winningLotto: Lotto, val bonusNumber: LottoNumber) {
    init {
        require(!winningLotto.lottoNumbers.contains(bonusNumber)) {
            "보너스 숫자는 기존 당첨 숫자와 달라야 합니다."
        }
    }

    fun findNumberOfMatch(lotto: Lotto): Int {
        return lotto.lottoNumbers.count { winningLotto.lottoNumbers.contains(it) }
    }
}
