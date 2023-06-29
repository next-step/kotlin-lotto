package lotto.domain.lottoStrategy

import lotto.domain.Lotto

interface LottoStrategy {
    val numberRange: IntRange
    val numberCount: Int

    fun makeLottoNumbers(): Lotto
}
