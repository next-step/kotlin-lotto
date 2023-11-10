package lotto.controller

import lotto.domain.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val lottoShop: LottoShop) {

    fun play() {
        val money = InputView().inputMoney()
        val lottos = butLottos(money)
        OutputView().printLottos(lottos)
        val winningLotto = InputView().inputWinningLotto()
        val bonusBall = InputView().inputBonusBall()
        val ranks = lottos.match(winningLotto, bonusBall)
        OutputView().printResult(ranks, money)
    }

    private fun butLottos(money: Money): Lottos {
        val inputManualLottoCount = InputView().inputManualLottoCount()
        val inputManualLotto = InputView().inputManualLotto(inputManualLottoCount)
        val leftMoney = money.minus(Money.fromCount(inputManualLottoCount))
        val autoLottos = buyLotto(leftMoney)
        return inputManualLotto.merge(autoLottos)
    }

    private fun buyLotto(money: Money): Lottos {
        return Lottos(lottoShop.buy(money))
    }
}
