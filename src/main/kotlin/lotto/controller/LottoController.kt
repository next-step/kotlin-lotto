package lotto.controller

import lotto.domain.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val lottoShop: LottoShop) {

    fun play() {
        val money = retry { InputView().inputMoney() }
        val lottos = buyLottos(money)
        OutputView().printLottos(lottos)
        val winningLotto = retry { InputView().inputWinningLotto() }
        val bonusBall = retry { InputView().inputBonusBall() }
        val ranks = lottos.match(winningLotto, bonusBall)
        OutputView().printResult(ranks, money)
    }

    private fun buyLottos(money: Money): Lottos {
        val (manualMoney, leftMoney) = retry { getMoney(money) }
        val autoLottos = buyLotto(leftMoney)
        val inputManualLotto = retry { InputView().inputManualLotto(manualMoney) }
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

    fun <T> retry(operation: () -> T): T {
        return try {
            return operation()
        } catch (e: Exception) {
            println(e.message)
            retry(operation)
        }
    }
}
