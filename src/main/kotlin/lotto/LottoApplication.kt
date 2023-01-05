package lotto

import lotto.model.LottoNumber
import lotto.model.LottoTicket
import lotto.model.Lottos
import lotto.model.Money
import lotto.model.WinningNumbers
import lotto.model.WinningResult
import lotto.service.LottoGenerator
import lotto.service.LottoShop
import lotto.view.InputView
import lotto.view.OutputView

class LottoApplication {
    fun play() {
        val lottos = buyLottos()
        val winningNumbers = drawWinningNumbers()
        checkLotteryResult(lottos, winningNumbers)
    }

    private fun checkLotteryResult(lottos: Lottos, winningNumbers: WinningNumbers) {
        val winningResult = WinningResult.of(lottos, winningNumbers)
        OutputView.printResult(winningResult)
    }

    private fun drawWinningNumbers(): WinningNumbers {
        val winningLottoInput = InputView.readWinningLotto()
        val bonusNumberInput = InputView.readBonusNumber()
        val winningLotto = LottoGenerator.fromString(winningLottoInput)
        val bonusNumber = LottoNumber.of(bonusNumberInput)
        return WinningNumbers(winningLotto, bonusNumber)
    }

    private fun buyLottos(): Lottos {
        val moneyInput = InputView.readMoney()
        val money = Money.of(moneyInput)

        val manualCount = InputView.readManualLottoCount().toInt()
        val manualNumbers = InputView.readManualLottos(manualCount)
        val lottoTicket = LottoTicket.of(manualNumbers)

        val lottos = LottoShop.buyLottos(money, lottoTicket)
        OutputView.printDetails(lottos, manualCount)
        return lottos
    }
}

fun main() {
    LottoApplication().play()
}
