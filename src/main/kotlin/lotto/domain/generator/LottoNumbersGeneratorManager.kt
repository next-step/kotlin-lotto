package lotto.domain.generator

import lotto.domain.LottoType

class LottoNumbersGeneratorManager {
    private val generators: MutableMap<LottoType, LottoNumbersGenerator> = mutableMapOf()

    fun addGenerator(lottoType: LottoType, generator: LottoNumbersGenerator) {
        generators.putIfAbsent(lottoType, generator)
    }

    fun getGenerator(lottoType: LottoType): LottoNumbersGenerator? = generators[lottoType]
}
