package lotto

class LottoManualGenerator : LottoGeneratorStrategy {

    override fun generate(count: Int): List<LottoNumbers> {
        return LottoManualService.generate(count)
    }
}
