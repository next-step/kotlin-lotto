package lotto

import lotto.adapter.LottoInputAdapter
import lotto.controller.LottoController
import lotto.domain.LottoBallMachine
import lotto.domain.LottoGame
import lotto.infrastructure.RandomLottoBallMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoBallMachine: LottoBallMachine = RandomLottoBallMachine()
    val adapter = LottoInputAdapter()

    val controller = LottoController(inputView, outputView, adapter)

    val lottoPurchaseAmount = controller.getLottoPurchaseAmount()
    val lottoGame = LottoGame.makeNewLottoGame(lottoPurchaseAmount, lottoBallMachine)

    controller.announcePurchasedLotto(lottoGame)
    controller.announceGameResult(lottoGame, lottoPurchaseAmount)
}
