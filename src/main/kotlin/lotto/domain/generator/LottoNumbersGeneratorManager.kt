package lotto.domain.generator

import lotto.domain.LottoType

class LottoNumbersGeneratorManager {
    private val generators: MutableMap<LottoType, LottosGenerator> = mutableMapOf()

    fun addGenerator(lottoType: LottoType, generator: LottosGenerator) =
        generators.putIfAbsent(lottoType, generator)

    fun getGenerator(lottoType: LottoType): LottosGenerator = generators[lottoType]
        ?: throw IllegalStateException("Could not find lottery generator mapped to $lottoType.")
}
