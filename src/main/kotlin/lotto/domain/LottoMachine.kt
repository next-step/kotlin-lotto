package lotto.domain

class LottoMachine(
    private val lottoNumberGenerator: LottoNumberGenerator
) {

    fun buy(manualLottoCount: ManualLottoCount, manualLottoNumbers: List<LottoNumbers>): Lottos {
        return Lottos.of(manualLottoCount.availableAutoCount, manualLottoNumbers, lottoNumberGenerator)
    }
}
