package lotto

import lotto.model.LottoNumber
import lotto.model.WinningNumbers
import lotto.model.WinningResult
import lotto.service.LottoGenerator
import lotto.service.LottoShop
import lotto.view.InputView
import lotto.view.OutputView
import java.math.BigDecimal

class LottoApplication {
    fun play() {
        val moneyInput = InputView.readMoney()
        val money = BigDecimal(moneyInput)
        val lottos = LottoShop.buyAutoLottos(money)
        OutputView.printDetails(lottos)

        val winningLottoInput = InputView.readWinningLotto()
        val bonusNumberInput = InputView.readBonusNumber()
        val winningLotto = LottoGenerator.fromString(winningLottoInput)
        val bonusNumber = LottoNumber.of(bonusNumberInput)
        val winningNumbers = WinningNumbers(winningLotto, bonusNumber)

        val winningResult = WinningResult.of(lottos, winningNumbers)
        OutputView.printResult(winningResult)
    }
}

fun main() {
    LottoApplication().play()
}
