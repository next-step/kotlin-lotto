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

    fun getResult(lottos: Lottos) {
        val matchingNumbers = InputView.readNumbers()
        val lottoResult = lottos.getLottoResult(matchingNumbers)

        OutputView.printLottoResult(lottoResult)
    }
}
