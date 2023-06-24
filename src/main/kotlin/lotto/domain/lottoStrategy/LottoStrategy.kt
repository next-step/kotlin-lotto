package lotto.domain.lottoStrategy

import lotto.domain.LottoNumbers

interface LottoStrategy {
    val numberRange: IntRange
    val numberCount: Int

    fun makeLottoNumbers(): LottoNumbers
}
