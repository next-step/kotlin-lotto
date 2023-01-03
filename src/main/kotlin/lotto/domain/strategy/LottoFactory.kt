package lotto.domain.strategy

import lotto.domain.Lottos

class LottoFactory {

    fun generate(lottoCount: Int, lottoGeneratorStrategy: LottoGeneratorStrategy): Lottos {
        return lottoGeneratorStrategy.generate(lottoCount)
    }
}
