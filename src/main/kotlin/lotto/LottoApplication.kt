package lotto

import lotto.model.WinningNumbers
import lotto.service.LottoShop
import lotto.view.InputView
import lotto.view.OutputView

class LottoApplication {
    fun play() {
        val money = InputView.readMoney()
        val lottos = LottoShop.buyAutoLottos(money)
        OutputView.printDetails(lottos)

        val winningLotto = InputView.readWinningLotto()
        val bonusNumber = InputView.readBonusNumber()
        val winningNumbers = WinningNumbers(winningLotto, bonusNumber)
        OutputView.printResult(lottos, winningNumbers)
    }
}

fun main() {
    LottoApplication().play()
}
