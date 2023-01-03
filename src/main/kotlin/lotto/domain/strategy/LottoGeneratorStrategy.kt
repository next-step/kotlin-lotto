package lotto.domain.strategy

import lotto.domain.Lottos

interface LottoGeneratorStrategy {

    fun generate(lottoCount: Int): Lottos
}
