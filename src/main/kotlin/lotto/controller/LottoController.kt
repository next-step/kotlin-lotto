package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoGame
import lotto.domain.LottoMarket
import lotto.domain.Money
import lotto.domain.User
import lotto.domain.WinningLotto
import lotto.service.InputParser
import lotto.view.LottoGameView
import lotto.view.LottoPaperView

class LottoController {

    fun start() {
        val user = getUser()

        LottoGameView.printManualNumberInput()
        val manualLottos = (1..user.manualAmount).map { Lotto(InputParser.parseLottoNumbers(readln())) }
        val manualLottoPaper = LottoMarket.buyManual(user = user, lottos = manualLottos)
        val autoLottoPaper = LottoMarket.buyMaxAutomation(user = user)

        LottoGameView.printBuyAmount(manualAmount = manualLottoPaper.size, autoAmount = autoLottoPaper.size)
        LottoPaperView.print(lottoPaper1 = manualLottoPaper, lottoPaper2 = autoLottoPaper)

        val winningLotto = getLastWinningLotto()

        val lottoGame = LottoGame(
            manualLottoPaper = manualLottoPaper,
            autoLottoPaper = autoLottoPaper,
            winningLotto = winningLotto
        )

        LottoGameView.printWinningStats(result = lottoGame.result)
    }

    private fun getUser(): User {
        val purchaseAmount = getPurchaseAmount()
        val manualAmount = getManualAmount()

        return User(money = Money(purchaseAmount), manualAmount = manualAmount)
    }

    private fun getPurchaseAmount(): Int {
        LottoGameView.printPurchaseAmountInput()

        return InputParser.parsePurchaseAmount(requireNotNull(readLine()))
    }

    private fun getManualAmount(): Int {
        LottoGameView.printManualAmountInput()

        return InputParser.parseManualAmount(readln())
    }

    private fun getLastWinningLotto(): WinningLotto {
        LottoGameView.printLastWinningNumbers()
        val lotto = Lotto(InputParser.parseLottoNumbers(readln()))

        LottoGameView.printBonusNumber()
        val bonusNumber = InputParser.parseBonusNumber(readln())

        return WinningLotto(lotto = lotto, bonusNumber = bonusNumber)
    }
}
