package lotto.controller

import lotto.domain.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val lottoShop: LottoShop) {

    fun play() {
        val money = InputView().inputMoney()
        val lottos = buyLottos(money)
        OutputView().printLottos(lottos)
        val winningLotto = InputView().inputWinningLotto()
        val bonusBall = InputView().inputBonusBall()
        val ranks = lottos.match(winningLotto, bonusBall)
        OutputView().printResult(ranks, money)
    }

    private fun buyLottos(money: Money): Lottos {
        val (manualMoney, leftMoney) = getMoney(money)
        val autoLottos = buyLotto(leftMoney)
        val inputManualLotto = InputView().inputManualLotto(manualMoney)
        return inputManualLotto.merge(autoLottos)
    }

    private fun getMoney(money: Money): Pair<Money, Money> {
        val inputManualLottoCount = InputView().inputManualLottoCount()
        val manualMoney = Money.fromCount(inputManualLottoCount)
        val leftMoney = money.minus(manualMoney)
        return Pair(manualMoney, leftMoney)
    }

    private fun buyLotto(money: Money): Lottos {
        return Lottos(lottoShop.buy(money))
    }
}
