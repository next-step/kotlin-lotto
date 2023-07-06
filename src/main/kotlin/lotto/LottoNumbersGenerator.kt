package lotto

class LottoNumbersGenerator(var strategy: LottoNumbersGenerateStrategy) {
    fun generate(): LottoNumbers = strategy.generate()
}
