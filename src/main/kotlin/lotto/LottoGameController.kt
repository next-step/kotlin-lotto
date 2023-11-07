package lotto

import lotto.domain.Lotto
import lotto.domain.LottoFactory
import lotto.domain.LottoResultChecker
import lotto.view.InputView

fun main() {
    val money = InputView.enterMoney()
    val lottoList = LottoFactory.buyLotto(money)
    val winningLotto = Lotto(InputView.enterWinningLotto())
    val lottoResultList = lottoList.map { LottoResultChecker.checkWinningLotto(winningLotto, it) }
}
