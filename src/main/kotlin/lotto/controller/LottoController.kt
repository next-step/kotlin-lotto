package lotto.controller

import lotto.domain.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    fun run() {
        val money = InputView.getBuyingMoney()
        val lottoMachine = LottoMachine(LottoMoney(money), RandomLottoNumbersGenerator)
        OutputView.printBuyingResult(lottoMachine.getLottos())

        val lotto = Lotto(numbers = InputView.getWinningLottoNumbers().map { LottoNumber.of(it) })
        val bonusNumber = InputView.getBonusNumber().let { LottoNumber.of(it) }
        val winningLotto = WinningLotto (lotto, bonusNumber)
        val lottoResult = LottoResult(LottoMoney(money), lottoMachine.lottos, winningLotto).getLottoResult()
        OutputView.printLottoRanks(lottoResult.lottoRanks)
        OutputView.printEarningRate(lottoResult.earningRate)
    }
}
