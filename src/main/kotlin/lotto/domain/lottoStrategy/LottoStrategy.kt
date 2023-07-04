package lotto.domain.lottoStrategy

import lotto.domain.Lotto

interface LottoStrategy {
    fun makeLotto(): Lotto
}
