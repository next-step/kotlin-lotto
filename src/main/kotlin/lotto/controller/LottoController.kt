package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoShop
import lotto.domain.Ranks
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val lottoShop: LottoShop) {

    fun play() {
        val money = InputView().inputMoney()
        val lottos = buyLotto(money)
        OutputView().printLottos(lottos)
        val winningLotto = Lotto(InputView().inputWinningLotto())
        val ranks = matchLotto(lottos, winningLotto)
        OutputView().printResult(ranks, money)
    }

    fun buyLotto(money: Int): List<Lotto> {
        return lottoShop.buy(money)
    }

    fun matchLotto(lottos: List<Lotto>, winningLotto: Lotto): Ranks {
        return Ranks(lottos.map { it.match(winningLotto) })
    }
}