package lotto.domain.strategy

import lotto.domain.Lotto

class LottoGenerator {

    fun generate(lottoCount: Int, lottoGeneratorStrategy: LottoGeneratorStrategy): Lotto {
        return lottoGeneratorStrategy.generate(lottoCount)
    }
}
