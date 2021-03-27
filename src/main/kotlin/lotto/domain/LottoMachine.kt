package lotto.domain

import lotto.domain.generator.LottoGenerator

class LottoMachine(
    private val lottoGenerator: LottoGenerator
) {
    fun buy(): Lotto {
        return lottoGenerator.generate()
    }
}
