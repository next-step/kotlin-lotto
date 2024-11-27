package lotto

import lotto.controller.LottoController
import lotto.domain.LottoBallMachine
import lotto.domain.LottoGame
import lotto.infrastructure.ConsoleLottoInputAdapter
import lotto.infrastructure.DefaultProfitRateCalculator
import lotto.infrastructure.RandomLottoBallMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoBallMachine: LottoBallMachine = RandomLottoBallMachine()
    val inputAdapter = ConsoleLottoInputAdapter(inputView)

    val controller = LottoController(inputAdapter, outputView, DefaultProfitRateCalculator())

    val lottoPurchaseAmount = controller.getLottoPurchaseAmount()
    val manualPurchaseCount = inputAdapter.fetchManualPurchaseCount()
    val manualLines = inputAdapter.fetchManualLines(manualPurchaseCount)

    val lottoGame = LottoGame.makeNewLottoGame(lottoPurchaseAmount, manualLines, lottoBallMachine)

    controller.announcePurchasedLotto(lottoGame, manualPurchaseCount)
    controller.announceGameResult(lottoGame, lottoPurchaseAmount)
}
