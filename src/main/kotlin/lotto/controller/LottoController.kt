package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoShop
import lotto.domain.Money
import lotto.domain.Ranks
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val lottoShop: LottoShop) {

    fun play() {
        val money = InputView().inputMoney()
        val lottos = buyLotto(money)
        OutputView().printLottos(lottos)
        val winningLotto = InputView().inputWinningLotto()
        val bonusBall = InputView().inputBonusBall()
        val ranks = matchLotto(lottos, winningLotto, bonusBall)
        OutputView().printResult(ranks, money)
    }

    private fun buyLotto(money: Money): List<Lotto> {
        return lottoShop.buy(money)
    }

    private fun matchLotto(lottos: List<Lotto>, winningLotto: Lotto, bonusBall: Int): Ranks {
        return Ranks(lottos.map { it.match(winningLotto, bonusBall) })
    }
}
