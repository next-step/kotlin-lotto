package lotto

import lotto.domain.*

class LottoManager(
    private val lottoMachine: LottoMachine
) {

    fun buyLottos(manualLottoCount: ManualLottoCount, manualLottoNumbers: List<LottoNumbers>): Lottos {
        return lottoMachine.buy(manualLottoCount, manualLottoNumbers)
    }

    fun getResult(lottos: Lottos, winningNumbers: LottoWinningNumbers): LottoResult {
        return lottos.getLottoResult(winningNumbers)
    }
}
