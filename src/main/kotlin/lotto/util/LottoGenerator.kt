package lotto.util

import lotto.domain.Lotto

interface LottoGenerator {
    fun getLotto(): Lotto
}
