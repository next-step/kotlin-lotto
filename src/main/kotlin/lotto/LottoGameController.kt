package lotto

import lotto.domain.Lotto
import lotto.domain.LottoFactory
import lotto.domain.LottoResultMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputMoney = InputView.enterMoney()
    val lottoList = LottoFactory.buyLotto(inputMoney)
    OutputView.buyLotto(lottoList)
    val winningLotto = Lotto(InputView.enterWinningLotto())
    val lottoResultMap = lottoList.map { LottoResultMachine.checkWinningLotto(winningLotto, it) }.groupBy { it.prize }
    OutputView.printLottoResult(lottoResultMap)
}
