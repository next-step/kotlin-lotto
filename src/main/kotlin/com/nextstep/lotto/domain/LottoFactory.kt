package com.nextstep.lotto.domain

object LottoFactory {
    fun drawRandomLotto(): Lotto {
        return Lotto(LottoNumbers.drawRandomNumbers().sortedBy { it.number })
    }

    fun drawManualLotto(lottoNumbers: List<Int>): Lotto {
        return Lotto(lottoNumbers.map { LottoNumbers.valueOf(it) })
    }
}
