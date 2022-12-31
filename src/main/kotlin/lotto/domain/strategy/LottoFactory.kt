package lotto.domain.strategy

import lotto.domain.Lotto

class LottoFactory {

    fun generate(lottoCount: Int, lottoGeneratorStrategy: LottoGeneratorStrategy): Lotto {
        return lottoGeneratorStrategy.generate(lottoCount)
    }
}
