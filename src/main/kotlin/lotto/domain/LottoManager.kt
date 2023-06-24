package lotto.domain

import lotto.ui.InputView
import lotto.ui.OutputView

class LottoManager {

    fun buyLotto(): Lottos {
        val price = InputView.readPrice()
        val lottos = LottoMachine().buy(price)

        OutputView.printLottos(lottos)

        return lottos
    }

    fun getResult(lottos: Lottos, matchingLottoNumbers: LottoNumbers) {
        val lottoResult = lottos.getLottoResult(matchingLottoNumbers)

        OutputView.printLottoResult(lottoResult)
    }
}
