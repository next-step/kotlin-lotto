package lotto.domain.strategy

import lotto.domain.Lotto

interface LottoGeneratorStrategy {

    fun generate(lottoCount: Int): Lotto
}
