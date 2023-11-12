package lotto

import lotto.domain.Lotto
import lotto.domain.LottoFactory
import lotto.domain.LottoResult
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputMoney = InputView.enterMoney()
    val lottoList = LottoFactory.buyLotto(inputMoney)
    OutputView.buyLotto(lottoList)
    val winningLotto = WinningLotto(Lotto(InputView.enterWinningLotto()))
    OutputView.printLottoResult(LottoResult(lottoList, winningLotto))
}
