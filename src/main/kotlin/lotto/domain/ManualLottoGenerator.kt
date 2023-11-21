package lotto.domain

class ManualLottoGenerator(
    private val lottoGenerator: LottoGenerator,
    vararg manualLottos: Lotto,
): LottoGenerator {
    private val manualLottoIterator = manualLottos.iterator()

    override fun generate(): Lotto {
        if (manualLottoIterator.hasNext()) {
            return manualLottoIterator.next()
        }
        return lottoGenerator.generate()
    }
}
