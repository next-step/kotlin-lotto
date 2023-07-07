package lotto.domain

class LottoMachine(
    private val lottoNumberGenerator: LottoNumberGenerator
) {

    fun buy(manualLottoCount: ManualLottoCount, manualLottoNumbers: List<LottoNumbers>): Lottos {
        val manualLottos = manualLottoNumbers.map { Lotto(it, LottoType.MANUAL) }
        val autoLottos = List(manualLottoCount.availableAutoCount) { Lotto.of(lottoNumberGenerator) }
        return Lottos.of(manualLottos, autoLottos)
    }
}
