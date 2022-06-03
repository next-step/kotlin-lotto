package lotto.domain

import lotto.domain.generator.LottoNumberGenerator

object LottoMachine {
    fun make(count: Int, generator: LottoNumberGenerator): List<LottoNumbers> {
        return List(count) { LottoNumbers(generator.generate(6)) }
    }
}
