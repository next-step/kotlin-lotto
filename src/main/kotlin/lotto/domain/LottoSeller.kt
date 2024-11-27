package lotto.domain

class LottoSeller(lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()) {
    private val lottoMachine = LottoMachine(lottoNumberGenerator)

    fun sellLottos(lottoCustomerInput: LottoCustomerInput): Lottos {
        val selectedLottos = lottoMachine.makeLottosSelected(lottoCustomerInput.selectLottosNumbers)
        val autoLottos = lottoMachine.makeLottosAuto(lottoCustomerInput.getLottoAutoCount())
        return Lottos(selectedLottos.lottos + autoLottos.lottos)
    }
}
