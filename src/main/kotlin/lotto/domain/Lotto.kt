package lotto.domain

import lotto.domain.generator.AutoLottoGenerator
import lotto.domain.generator.LottoGenerator

data class Lotto(private val generator: LottoGenerator = AutoLottoGenerator) {
    val numbers = generator.execute().sorted()

    override fun toString() = "[${numbers.joinToString()}]"
}
