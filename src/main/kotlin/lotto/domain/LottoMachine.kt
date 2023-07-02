package lotto.domain

class LottoMachine {

    fun buy(manualLottoCount: ManualLottoCount, manualLottoNumbers: List<LottoNumbers>): Lottos {
        return Lottos.of(manualLottoCount.availableAutoCount, manualLottoNumbers)
    }
}
